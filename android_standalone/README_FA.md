# دانشنامه جامع شبکه — اندروید کاملاً مستقل (۰.۴.۳-standalone)

بدون نیاز به ویندوز. موتور FastAPI+SQLite داخل خود اپ با Chaquopy روی 127.0.0.1:8765 اجرا می‌شود و WebView همان رابط را نشان می‌دهد.

## ساخت APK

1. پروژهٔ کامل `android_standalone` را از Release/Artifacts دانلود کن (یا از بسته‌ای که در چت ساخته شده).
2. در Android Studio باز کن → Gradle Sync
3. `Build → Build APK(s)` یا `./gradlew :app:assembleDebug`
4. خروجی: `app/build/outputs/apk/debug/app-debug.apk`

## محتوا همراه نصب
فصل‌های ۱، ۲۱، ۳۰، ۳۱، ۳۲ از content_pack در اولین اجرا seed می‌شوند.

## ABI
arm64-v8a ، x86_64

سازنده: مهندس مسعود جوکار
