# یادداشت انتشار ۰.۴.۱ روی GitHub

## مخزن
https://github.com/MrUtility01/network-learning-app

## آنچه در Git بارگذاری شده
- ساختار پروژه و اسکریپت‌های اجرای ویندوز/لینوکس
- PWA (`static/manifest.webmanifest`, `static/sw.js`)
- پروژهٔ اندروید WebView (`android/`)
- دستورالعمل ساخت فصل با بخش اندروید (`Chapter_Authoring_Kit/README_FA.md`)

## آنچه باید از ZIP کامل اضافه شود (به دلیل حجم)
فایل‌های حجیم `app.py`، `static/index.html` و `content_pack/` را از بستهٔ `Network_Learning_App_v0.4.1_FA.zip` روی کلون کپی کن، یا همان ZIP را در بخش **Releases** گیت‌هاب به‌عنوان Asset آپلود کن.

### دستور پیشنهادی پس از clone
```bash
git clone https://github.com/MrUtility01/network-learning-app.git
cd network-learning-app
# سپس محتوای ZIP نسخهٔ ۰.۴.۱ را روی این پوشه استخراج/ادغام کن
```

## اندروید
1. PWA از Chrome پس از روشن بودن سرور ویندوز
2. ساخت APK از پوشهٔ `android/` در Android Studio
