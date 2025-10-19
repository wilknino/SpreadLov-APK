# SpreadLov Android Studio Project

## Project Type
**Android Studio Reference Project** - This is a complete Android app project structure generated as reference files for local development. This project **cannot be built or run in Replit** as it requires Android Studio and Android SDK.

## Project Overview
- **Purpose:** Generate Android app for SpreadLov dating website (https://spreadlov.com)
- **Format:** Complete Android Studio project with Kotlin source files
- **User Intent:** Download these files and import into Android Studio on local machine

## App Details
- **App Name:** SpreadLov
- **Package:** com.spreadlov.app
- **Language:** Kotlin
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 35 (Android 15)
- **Theme:** Dark mode (#121212) with pink accent (#E91E63)

## Features Implemented
1. ✅ Splash screen with fade animation
2. ✅ Secure WebView (HTTPS-only, domain-restricted)
3. ✅ Offline detection and retry screen
4. ✅ Push notifications (Firebase FCM)
5. ✅ About screen with app info and links
6. ✅ 3-dot menu (About, Share, Rate)
7. ✅ Swipe-to-refresh with pink loader
8. ✅ Back navigation with exit confirmation
9. ✅ External intent handling (mail, tel, etc.)

## Project Structure
```
SpreadLov/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/spreadlov/app/
│   │   │   ├── Activities (Splash, Main, Offline, About)
│   │   │   └── util/ (WebView, Network, Notifications, Intents, FCM)
│   │   └── res/ (layouts, values, drawables, menu)
│   ├── build.gradle.kts
│   └── google-services.json (placeholder - needs replacement)
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Important Notes
- **Cannot run in Replit:** This requires Android Studio and Android SDK
- **For download only:** User must import into Android Studio on their machine
- **Firebase setup required:** Replace placeholder google-services.json with real file
- **All files complete:** Ready for Android Studio import

## Next Steps for User
1. Download/clone this project from Replit
2. Import into Android Studio
3. Replace `app/google-services.json` with real Firebase config
4. Sync Gradle and build
5. Run on Android device/emulator

## Architecture
- **Activities:** Splash → Main (WebView) ↔ Offline ↔ About
- **Security:** HTTPS-only, domain restriction, Safe Browsing
- **Storage:** Cookies and DOM storage enabled for website
- **Notifications:** FCM service configured (needs Firebase setup)

## User Preferences
- Requested complete Android Studio project structure
- Dark theme with pink branding
- Secure WebView wrapper for dating website
- Push notification support
- Share and rate functionality
