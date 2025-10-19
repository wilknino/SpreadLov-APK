# SpreadLov Android App

A secure, dark-themed WebView-based Android application for the SpreadLov dating platform (https://spreadlov.com).

## 📱 App Overview

- **Package Name:** `com.spreadlov.app`
- **Minimum SDK:** 24 (Android 7.0)
- **Target SDK:** 35 (Android 15)
- **Language:** Kotlin
- **Build System:** Gradle (KTS)
- **Theme:** Dark mode with pink accent (#E91E63)

## ✨ Features

### Core Features
- ✅ **Splash Screen** - Animated logo and app name with fade-in effect
- ✅ **Secure WebView** - HTTPS-only connection to spreadlov.com
- ✅ **Offline Detection** - Auto-redirect to offline screen when no internet
- ✅ **Swipe to Refresh** - Manual page reload with pink accent loader
- ✅ **Push Notifications** - Firebase Cloud Messaging integration
- ✅ **About Screen** - App info, version, and links
- ✅ **Back Navigation** - WebView history navigation with exit confirmation
- ✅ **3-Dot Menu** - About, Share App, and Rate Us options

### Security Features
- 🔒 HTTPS-only (no cleartext traffic)
- 🔒 Domain restriction to spreadlov.com
- 🔒 Safe Browsing enabled
- 🔒 Mixed content blocked
- 🔒 External links open in system browser

## 📂 Project Structure

```
SpreadLov/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/spreadlov/app/
│   │   │   ├── SplashActivity.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── OfflineActivity.kt
│   │   │   ├── AboutActivity.kt
│   │   │   └── util/
│   │   │       ├── WebViewClientHelper.kt
│   │   │       ├── NetworkUtils.kt
│   │   │       ├── NotificationUtils.kt
│   │   │       ├── IntentUtils.kt
│   │   │       └── MyFirebaseMessagingService.kt
│   │   └── res/
│   │       ├── layout/
│   │       ├── values/
│   │       ├── menu/
│   │       ├── drawable/
│   │       └── mipmap-anydpi-v26/
│   ├── build.gradle.kts
│   ├── google-services.json (PLACEHOLDER - Replace with real file)
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## 🚀 How to Import into Android Studio

### Step 1: Download/Clone the Project
1. Download this project folder to your local machine
2. Extract if it's in a ZIP file

### Step 2: Open in Android Studio
1. Open **Android Studio**
2. Click **File → Open**
3. Navigate to the `SpreadLov` folder
4. Click **OK**
5. Wait for Gradle sync to complete

### Step 3: Configure Firebase (Important!)
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project or select existing project
3. Add an Android app with package name: `com.spreadlov.app`
4. Download the **google-services.json** file
5. **Replace** the placeholder `app/google-services.json` with your real file

### Step 4: Sync and Build
1. Click **File → Sync Project with Gradle Files**
2. Wait for sync to complete
3. Click **Build → Make Project**

### Step 5: Run the App
1. Connect an Android device or start an emulator
2. Click the **Run** button (green triangle)
3. Select your device
4. The app will install and launch

## ⚙️ Configuration

### App Branding
- App name: Edit `app/src/main/res/values/strings.xml`
- Colors: Edit `app/src/main/res/values/colors.xml`
- Logo: Replace `app/src/main/res/drawable/app_logo.xml` with your logo

### App Icon
- Replace launcher icons in `app/src/main/res/mipmap-*/` folders
- Or use **Image Asset Studio** in Android Studio:
  - Right-click `res` → New → Image Asset
  - Configure your icon and click **Next**

### Version & Package
- Edit `app/build.gradle.kts`:
  - `versionCode` - Increment for each release
  - `versionName` - User-facing version number
  - `applicationId` - Package name (already set to `com.spreadlov.app`)

## 📦 Dependencies

```kotlin
androidx.core:core-ktx:1.13.1
androidx.appcompat:appcompat:1.7.0
com.google.android.material:material:1.12.0
androidx.constraintlayout:constraintlayout:2.2.0
androidx.webkit:webkit:1.10.0
androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01
com.google.firebase:firebase-messaging:24.1.0
```

## 🔔 Push Notifications Setup

1. **Firebase Setup** (see Step 3 above)
2. **Test Notifications:**
   - Go to Firebase Console → Cloud Messaging
   - Click **Send your first message**
   - Enter title and message
   - Select your app
   - Send test notification

3. **Production:** Integrate with your backend to send notifications via FCM API

## 🎨 Color Scheme

- **Dark Background:** `#121212`
- **Pink Accent:** `#E91E63`
- **Light Gray:** `#B0B0B0`
- **Text:** White/Light Gray

## 🔐 Permissions

The app requests these permissions:
- `INTERNET` - Load website content
- `ACCESS_NETWORK_STATE` - Check connectivity
- `POST_NOTIFICATIONS` - Show push notifications (Android 13+)

## 📝 Release Build

### Generate Signed APK
1. **Create Keystore:**
   - Build → Generate Signed Bundle/APK
   - Select APK → Next
   - Create new keystore and fill in details
   - **Save keystore credentials safely!**

2. **Build Release APK:**
   - Build → Generate Signed Bundle/APK
   - Select your keystore
   - Choose **release** build variant
   - Click Finish

3. **APK Location:**
   - `app/release/app-release.apk`

### Publish to Play Store
1. Create a Google Play Developer account
2. Build → Generate Signed Bundle/APK → **Android App Bundle (AAB)**
3. Upload AAB to Play Console
4. Fill in store listing details
5. Submit for review

## 🐛 Troubleshooting

### Gradle Sync Failed
- Check your internet connection
- File → Invalidate Caches → Invalidate and Restart
- Update Android Studio to latest version

### google-services.json Error
- Make sure you replaced the placeholder file
- Verify package name matches: `com.spreadlov.app`
- Re-download from Firebase Console

### App Crashes on Startup
- Check Logcat for error messages
- Verify internet permission in AndroidManifest.xml
- Ensure device/emulator has internet connection

### WebView Not Loading
- Check if https://spreadlov.com is accessible
- Verify device has internet connection
- Check Logcat for WebView errors

## 📄 License

This project is created for SpreadLov. All rights reserved.

## 📞 Support

For issues or questions:
- Website: https://spreadlov.com
- Review app logs in Android Studio Logcat
- Check Firebase Console for push notification issues

---

**Note:** This is a reference Android Studio project. It cannot run in Replit - you must import it into Android Studio on your local machine to build and run the APK.
