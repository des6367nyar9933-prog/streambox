# Android Studio / Gradle project for StreamBox

This repo contains a starter Android app for a streaming platform with movie, music, and AI assistant sections.

## Requirements

- Android Studio Iguana or newer
- JDK 17+
- Android SDK 34
- Internet access for Gradle dependencies

## Open in Android Studio

1. Open the repository in Android Studio.
2. Let Gradle sync complete.
3. Select an emulator or connected device.
4. Click Run > Run 'app'.

## Build APK

1. In Android Studio, open the Build menu.
2. Select Build Bundle(s) / APK(s).
3. Choose Build APK(s).
4. Android Studio will generate the APK in:
   - app/build/outputs/apk/debug/
   - app/build/outputs/apk/release/

## Notes

This is a starter UI and architecture for a media streaming app. To make it production-ready, you will need:

- real video/music streaming integration
- authentication and user accounts
- AI assistant backend
- movie/music catalog storage
- app icon and branding assets
- signing key for release APK

## Recommended next steps

- Add login/signup screens
- Add video player screen
- Add music player screen
- Connect to a backend or REST API
- Integrate a chatbot or AI API
- Generate a signed release APK for distribution
