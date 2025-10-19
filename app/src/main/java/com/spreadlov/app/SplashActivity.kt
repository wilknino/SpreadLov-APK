package com.spreadlov.app

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.spreadlov.app.util.NetworkUtils

class SplashActivity : AppCompatActivity() {

    private val splashDelay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoView = findViewById<View>(R.id.splash_logo)
        val appNameView = findViewById<View>(R.id.splash_app_name)

        val fadeInLogo = ObjectAnimator.ofFloat(logoView, "alpha", 0f, 1f).apply {
            duration = 1000
            interpolator = AccelerateInterpolator()
        }

        val fadeInName = ObjectAnimator.ofFloat(appNameView, "alpha", 0f, 1f).apply {
            duration = 1000
            startDelay = 300
            interpolator = AccelerateInterpolator()
        }

        fadeInLogo.start()
        fadeInName.start()

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNextScreen()
        }, splashDelay)
    }

    private fun navigateToNextScreen() {
        val intent = if (NetworkUtils.isNetworkAvailable(this)) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, OfflineActivity::class.java)
        }
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
