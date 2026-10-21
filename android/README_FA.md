# نسخهٔ اندروید — دانشنامه جامع شبکه

این پوشه دو مسیر برای استفاده روی اندروید دارد:

## مسیر ۱ — PWA (سریع، بدون ساخت APK)

1. روی رایانه برنامه را با `run_windows.bat` یا `./start_linux_mac.sh` اجرا کن.
2. گوشی و رایانه باید در **یک شبکهٔ محلی** باشند (مثلاً همان Wi‑Fi).
3. در Windows، آدرس IP رایانه را با `ipconfig` پیدا کن (مثلاً `192.168.1.10`).
4. در مرورگر Chrome اندروید برو به: `http://192.168.1.10:8000`
5. منوی Chrome → **Add to Home screen** / **نصب برنامه**.
6. آیکون روی صفحهٔ اصلی ظاهر می‌شود و مثل اپ نصب‌شده باز می‌شود.

> برنامه همچنان محلی است؛ سرور روی رایانه باید روشن باشد مگر اینکه بعداً backend را روی گوشی هم اجرا کنید.

## مسیر ۲ — APK با WebView (Android Studio)

پروژهٔ زیر یک WebView است که به همان سرور محلی (یا آدرس قابل تنظیم) وصل می‌شود.

### پیش‌نیاز
- Android Studio Ladybug یا جدیدتر
- JDK 17
- دستگاه اندروید یا امولاتور API 26+

### ساخت
```bash
cd android
# در Android Studio: Open این پوشه
# یا از خط فرمان (با SDK نصب‌شده):
./gradlew assembleDebug
```
خروجی: `app/build/outputs/apk/debug/app-debug.apk`

### تنظیم آدرس سرور
در `app/src/main/java/.../MainActivity.kt` مقدار `DEFAULT_SERVER` را به IP رایانهٔ خودت تغییر بده.

### امنیت شبکهٔ محلی
در `res/xml/network_security_config.xml` دسترسی cleartext به HTTP محلی مجاز شده است.

## همگام‌سازی محتوا با ویندوز
- همان فایل‌های `content_pack` و ZIP فصل روی ویندوز Import می‌شوند.
- اندروید فقط کلاینت UI است و به API همان سرور متصل می‌شود.

## ساخت فصل برای اندروید
همان **Chapter_Authoring_Kit** ویندوز؛ فرمت JSON یکسان است. جزئیات در `Chapter_Authoring_Kit/README_FA.md` بخش «اندروید و PWA».
