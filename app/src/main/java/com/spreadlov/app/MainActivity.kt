package com.spreadlov.app

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.spreadlov.app.util.IntentUtils
import com.spreadlov.app.util.NetworkUtils
import com.spreadlov.app.util.NotificationUtils
import com.spreadlov.app.util.WebViewClientHelper

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    
    private var filePathCallback: ValueCallback<Array<Uri>>? = null
    private var fileChooserParams: WebChromeClient.FileChooserParams? = null
    
    private var backPressedTime: Long = 0
    private val backPressDelay: Long = 2000

    companion object {
        private const val WEBSITE_URL = "https://spreadlov.com"
        private const val PERMISSION_REQUEST_CODE = 200
    }

    private val fileChooserLauncher: ActivityResultLauncher<Intent> = 
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val results = result.data?.let { intent ->
                    intent.clipData?.let { clipData ->
                        Array(clipData.itemCount) { i ->
                            clipData.getItemAt(i).uri
                        }
                    } ?: intent.data?.let { arrayOf(it) }
                }
                filePathCallback?.onReceiveValue(results)
            } else {
                filePathCallback?.onReceiveValue(null)
            }
            filePathCallback = null
        }

    private val permissionLauncher: ActivityResultLauncher<Array<String>> = 
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                openFileChooser()
            } else {
                Toast.makeText(this, "Storage permission required for file upload", Toast.LENGTH_SHORT).show()
                filePathCallback?.onReceiveValue(null)
                filePathCallback = null
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSystemBars()

        webView = findViewById(R.id.webView)
        swipeRefreshLayout = findViewById(R.id.swipeRefresh)
        progressBar = findViewById(R.id.progressBar)

        setupWindowInsets()
        setupWebView()
        setupSwipeRefresh()
        
        NotificationUtils.requestNotificationPermission(this)

        if (NetworkUtils.isNetworkAvailable(this)) {
            webView.loadUrl(WEBSITE_URL)
        } else {
            startActivity(Intent(this, OfflineActivity::class.java))
            finish()
        }
    }

    private fun setupSystemBars() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            )
        }
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(swipeRefreshLayout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                0,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    private fun setupWebView() {
        WebViewClientHelper.setupWebView(
            webView = webView,
            context = this,
            onPageStarted = { 
                progressBar.visibility = ProgressBar.VISIBLE
                swipeRefreshLayout.isRefreshing = true
            },
            onPageFinished = { 
                progressBar.visibility = ProgressBar.GONE
                swipeRefreshLayout.isRefreshing = false
            },
            onError = {
                if (!NetworkUtils.isNetworkAvailable(this)) {
                    startActivity(Intent(this, OfflineActivity::class.java))
                    finish()
                }
            },
            onFileChooser = { callback, params ->
                filePathCallback = callback
                fileChooserParams = params
                checkPermissionsAndOpenFileChooser()
                true
            }
        )
    }

    private fun setupSwipeRefresh() {
        swipeRefreshLayout.setColorSchemeResources(R.color.pink_accent)
        
        swipeRefreshLayout.setOnChildScrollUpCallback { _, _ ->
            webView.scrollY > 0
        }
        
        swipeRefreshLayout.setOnRefreshListener {
            if (NetworkUtils.isNetworkAvailable(this)) {
                webView.reload()
            } else {
                swipeRefreshLayout.isRefreshing = false
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPermissionsAndOpenFileChooser() {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.CAMERA
            )
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
        }

        val permissionsToRequest = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }

        if (permissionsToRequest.isEmpty()) {
            openFileChooser()
        } else {
            permissionLauncher.launch(permissionsToRequest.toTypedArray())
        }
    }

    private fun openFileChooser() {
        val intent = fileChooserParams?.createIntent() ?: Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        }
        
        try {
            fileChooserLauncher.launch(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Cannot open file chooser", Toast.LENGTH_SHORT).show()
            filePathCallback?.onReceiveValue(null)
            filePathCallback = null
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            if (backPressedTime + backPressDelay > System.currentTimeMillis()) {
                super.onBackPressed()
            } else {
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
            }
            backPressedTime = System.currentTimeMillis()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webView.restoreState(savedInstanceState)
    }
}
