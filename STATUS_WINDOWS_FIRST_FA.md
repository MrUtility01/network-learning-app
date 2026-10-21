# وضعیت مخزن — مسیر ویندوز اول

به‌روز: ۲۰۲۶-۱۰-۲۲

## تصمیم محصول

- **منبع حقیقت و مسیر رسمی:** نسخهٔ ویندوز **۰.۴.۳** در پوشهٔ `new/`
- اندروید در این مخزن = **همراه** همان سرور (PWA یا WebView)، نه جایگزین مستقل اجباری
- اپ بومی کاملاً آفلاین (Kotlin/Room) در مخزن جدا: **NetworkAll**

## لینک‌های رسمی این مخزن

| مورد | لینک |
|------|------|
| ویندوز کامل ۰.۴.۳ | https://github.com/MrUtility01/network-learning-app/raw/main/new/Network_Learning_App_v0.4.3_FA.zip |
| پوشهٔ new (فصل‌ها) | https://github.com/MrUtility01/network-learning-app/tree/main/new |
| WebView اندروید | https://github.com/MrUtility01/network-learning-app/tree/main/android |
| مخزن ریشه | https://github.com/MrUtility01/network-learning-app |

## APK بومی (خارج از این مخزن)

| مورد | لینک |
|------|------|
| NetworkAll | https://github.com/MrUtility01/NetworkAll |
| CI ساخت APK (موفق) | https://github.com/MrUtility01/NetworkAll/actions/runs/39691473803 |

## محدودیت آپلود باینری از ابزار

فایل‌های چندمگابایتی (ZIP کامل برنامه / APK) از طریق API اتصال گیت به‌صورت مستقیم push نمی‌شوند.
نسخهٔ ویندوز را خودت در `new/` گذاشتی — همان منبع دانلود رسمی است.
برای APK از Artifact اکشن NetworkAll استفاده کن یا در GitHub Releases آپلود دستی کن.

## کار بعدی پیشنهادی (ویندوز‌محور)

1. Import فصل‌های باقی‌مانده از ZIPهای `new/`
2. بازبینی `review_required` در مدیریت محتوا
3. در صورت نیاز: Release گیت‌هاب با تگ `v0.4.3` و همان ZIP
