package com.spreadlov.app.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object IntentUtils {

    private const val PLAY_STORE_PACKAGE = "com.android.vending"
    private const val APP_PACKAGE_NAME = "com.spreadlov.app"

    fun shareApp(context: Context) {
        val shareText = "Check out SpreadLov – a free, genuine dating platform! 💕\nhttps://spreadlov.com"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
            putExtra(Intent.EXTRA_SUBJECT, "SpreadLov - Dating App")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share SpreadLov via"))
    }

    fun rateApp(context: Context) {
        try {
            val playStoreIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("market://details?id=$APP_PACKAGE_NAME")
                setPackage(PLAY_STORE_PACKAGE)
            }
            
            if (isPlayStoreInstalled(context)) {
                context.startActivity(playStoreIntent)
            } else {
                openPlayStoreInBrowser(context)
            }
        } catch (e: ActivityNotFoundException) {
            openPlayStoreInBrowser(context)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to open Play Store", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isPlayStoreInstalled(context: Context): Boolean {
        return try {
            context.packageManager.getPackageInfo(PLAY_STORE_PACKAGE, 0)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun openPlayStoreInBrowser(context: Context) {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com/store/apps/details?id=$APP_PACKAGE_NAME")
        )
        context.startActivity(webIntent)
    }
}
