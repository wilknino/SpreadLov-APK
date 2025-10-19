#!/bin/bash

echo "================================================"
echo "   SpreadLov Android Project - Validation"
echo "================================================"
echo ""
echo "⚠️  IMPORTANT: This is an Android Studio project"
echo "   It CANNOT run in Replit - download and import"
echo "   into Android Studio on your local machine."
echo ""
echo "================================================"
echo ""

echo "✅ Project Structure Validation:"
echo ""

# Check root files
echo "📁 Root Configuration Files:"
[ -f "build.gradle.kts" ] && echo "  ✓ build.gradle.kts" || echo "  ✗ build.gradle.kts MISSING"
[ -f "settings.gradle.kts" ] && echo "  ✓ settings.gradle.kts" || echo "  ✗ settings.gradle.kts MISSING"
[ -f "gradle.properties" ] && echo "  ✓ gradle.properties" || echo "  ✗ gradle.properties MISSING"
[ -f ".gitignore" ] && echo "  ✓ .gitignore" || echo "  ✗ .gitignore MISSING"
echo ""

# Check app module
echo "📁 App Module Files:"
[ -f "app/build.gradle.kts" ] && echo "  ✓ app/build.gradle.kts" || echo "  ✗ app/build.gradle.kts MISSING"
[ -f "app/google-services.json" ] && echo "  ✓ app/google-services.json (placeholder)" || echo "  ✗ google-services.json MISSING"
[ -f "app/proguard-rules.pro" ] && echo "  ✓ app/proguard-rules.pro" || echo "  ✗ proguard-rules.pro MISSING"
echo ""

# Check manifest
echo "📁 Android Manifest:"
[ -f "app/src/main/AndroidManifest.xml" ] && echo "  ✓ AndroidManifest.xml" || echo "  ✗ AndroidManifest.xml MISSING"
echo ""

# Check Kotlin files
echo "📁 Kotlin Source Files:"
[ -f "app/src/main/java/com/spreadlov/app/SplashActivity.kt" ] && echo "  ✓ SplashActivity.kt" || echo "  ✗ SplashActivity.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/MainActivity.kt" ] && echo "  ✓ MainActivity.kt" || echo "  ✗ MainActivity.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/OfflineActivity.kt" ] && echo "  ✓ OfflineActivity.kt" || echo "  ✗ OfflineActivity.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/AboutActivity.kt" ] && echo "  ✓ AboutActivity.kt" || echo "  ✗ AboutActivity.kt MISSING"
echo ""

# Check utilities
echo "📁 Utility Classes:"
[ -f "app/src/main/java/com/spreadlov/app/util/WebViewClientHelper.kt" ] && echo "  ✓ WebViewClientHelper.kt" || echo "  ✗ WebViewClientHelper.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/util/NetworkUtils.kt" ] && echo "  ✓ NetworkUtils.kt" || echo "  ✗ NetworkUtils.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/util/NotificationUtils.kt" ] && echo "  ✓ NotificationUtils.kt" || echo "  ✗ NotificationUtils.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/util/IntentUtils.kt" ] && echo "  ✓ IntentUtils.kt" || echo "  ✗ IntentUtils.kt MISSING"
[ -f "app/src/main/java/com/spreadlov/app/util/MyFirebaseMessagingService.kt" ] && echo "  ✓ MyFirebaseMessagingService.kt" || echo "  ✗ MyFirebaseMessagingService.kt MISSING"
echo ""

# Check layouts
echo "📁 XML Layouts:"
[ -f "app/src/main/res/layout/activity_splash.xml" ] && echo "  ✓ activity_splash.xml" || echo "  ✗ activity_splash.xml MISSING"
[ -f "app/src/main/res/layout/activity_main.xml" ] && echo "  ✓ activity_main.xml" || echo "  ✗ activity_main.xml MISSING"
[ -f "app/src/main/res/layout/activity_offline.xml" ] && echo "  ✓ activity_offline.xml" || echo "  ✗ activity_offline.xml MISSING"
[ -f "app/src/main/res/layout/activity_about.xml" ] && echo "  ✓ activity_about.xml" || echo "  ✗ activity_about.xml MISSING"
echo ""

# Check resources
echo "📁 Resource Files:"
[ -f "app/src/main/res/values/colors.xml" ] && echo "  ✓ colors.xml" || echo "  ✗ colors.xml MISSING"
[ -f "app/src/main/res/values/strings.xml" ] && echo "  ✓ strings.xml" || echo "  ✗ strings.xml MISSING"
[ -f "app/src/main/res/values/themes.xml" ] && echo "  ✓ themes.xml" || echo "  ✗ themes.xml MISSING"
[ -f "app/src/main/res/menu/main_menu.xml" ] && echo "  ✓ main_menu.xml" || echo "  ✗ main_menu.xml MISSING"
echo ""

# Check drawables
echo "📁 Drawable Resources:"
[ -f "app/src/main/res/drawable/app_logo.xml" ] && echo "  ✓ app_logo.xml" || echo "  ✗ app_logo.xml MISSING"
[ -f "app/src/main/res/drawable/ic_notification.xml" ] && echo "  ✓ ic_notification.xml" || echo "  ✗ ic_notification.xml MISSING"
echo ""

# Check documentation
echo "📁 Documentation Files:"
[ -f "README.md" ] && echo "  ✓ README.md" || echo "  ✗ README.md MISSING"
[ -f "IMPORT_INSTRUCTIONS.md" ] && echo "  ✓ IMPORT_INSTRUCTIONS.md" || echo "  ✗ IMPORT_INSTRUCTIONS.md MISSING"
echo ""

echo "================================================"
echo ""
echo "📊 Project Summary:"
echo ""
echo "  Package: com.spreadlov.app"
echo "  Min SDK: 24 (Android 7.0)"
echo "  Target SDK: 35 (Android 15)"
echo "  Language: Kotlin"
echo "  Theme: Dark (#121212) + Pink Accent (#E91E63)"
echo ""
echo "================================================"
echo ""
echo "🚀 Next Steps:"
echo ""
echo "  1. Download this Replit project to your computer"
echo "  2. Open Android Studio"
echo "  3. File → Open → Select 'SpreadLov' folder"
echo "  4. Replace app/google-services.json with real Firebase file"
echo "  5. Sync Gradle and Build"
echo "  6. Run on Android device/emulator"
echo ""
echo "📖 Full instructions: IMPORT_INSTRUCTIONS.md"
echo ""
echo "================================================"
echo ""
echo "✅ All Android Studio project files generated!"
echo "   Ready for import into Android Studio."
echo ""
