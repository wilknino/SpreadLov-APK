# 🚀 Android Studio Import Instructions

## ⚠️ IMPORTANT: This is an Android Reference Project

This project contains **complete Android Studio project files** but **CANNOT run in Replit**. You must import it into Android Studio on your local computer.

## Quick Start Guide

### 1️⃣ Download This Project
```bash
# Clone or download this Replit project to your local machine
# Or use Replit's download feature to get a ZIP file
```

### 2️⃣ Open in Android Studio
1. Launch **Android Studio**
2. Click **File → Open**
3. Navigate to the downloaded `SpreadLov` folder
4. Click **OK**
5. Wait for Gradle sync (may take 2-5 minutes first time)

### 3️⃣ Configure Firebase
**CRITICAL:** The `app/google-services.json` is a placeholder and will cause build errors.

1. Go to https://console.firebase.google.com/
2. Create a new project named "SpreadLov"
3. Click **Add app → Android**
4. Enter package name: `com.spreadlov.app`
5. Download **google-services.json**
6. **Replace** `app/google-services.json` with your downloaded file

### 4️⃣ Build & Run
1. Connect Android device via USB (with USB debugging enabled)
   - OR start Android emulator in Android Studio
2. Click **Run** button (green triangle icon)
3. Select your device
4. App will install and launch!

## ✅ What's Included

All these files are ready to use:
- ✅ Kotlin activities (Splash, Main, Offline, About)
- ✅ Utility classes (WebView, Network, Notifications, Intents)
- ✅ XML layouts (all 4 screens)
- ✅ Resource files (colors, strings, themes, menu)
- ✅ Gradle build files (KTS format)
- ✅ AndroidManifest.xml with permissions
- ✅ Drawable resources and app icons
- ✅ ProGuard rules for release builds

## 🎨 Customization

### Change App Name
Edit: `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">YourAppName</string>
```

### Change Colors
Edit: `app/src/main/res/values/colors.xml`
```xml
<color name="pink_accent">#E91E63</color>
<color name="dark_background">#121212</color>
```

### Change App Icon
1. Right-click `res` folder → **New → Image Asset**
2. Select icon type: Launcher Icons
3. Upload your logo image
4. Configure and click **Next → Finish**

### Update Version
Edit: `app/build.gradle.kts`
```kotlin
versionCode = 1  // Increment for each release
versionName = "1.0.0"  // User-facing version
```

## 🐛 Common Issues

### "google-services.json missing" Error
- Download real file from Firebase Console
- Replace placeholder file in `app/` folder
- Sync Gradle again

### Gradle Sync Failed
- Check internet connection
- Update Android Studio to latest version
- File → Invalidate Caches → Restart

### App Won't Install
- Enable USB debugging on device
- Check device is connected: `adb devices`
- Try: Build → Clean Project → Rebuild

## 📱 Testing

1. **Test on Emulator:**
   - Tools → Device Manager → Create Virtual Device
   - Select device (Pixel 6) → Next
   - Select system image (API 35) → Next → Finish

2. **Test on Real Device:**
   - Enable Developer Options on your Android phone
   - Enable USB Debugging
   - Connect via USB and allow debugging prompt

## 🚀 Release Build

### Generate Signed APK
1. Build → Generate Signed Bundle/APK
2. Create new keystore (save credentials safely!)
3. Select **release** build variant
4. Finish → APK saved in `app/release/`

### For Play Store
1. Build → Generate Signed Bundle/APK
2. Select **Android App Bundle (.aab)**
3. Upload to Google Play Console

## 📞 Need Help?

- Check `README.md` for full documentation
- Review Android Studio Logcat for errors
- Verify https://spreadlov.com is accessible
- Check Firebase Console for FCM setup

---

**Remember:** This project is for Android Studio only. It cannot build or run in Replit!
