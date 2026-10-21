# دانشنامه جامع شبکه — Network Learning App

**نسخه:** ۰.۴.۱  
**سازنده:** مهندس مسعود جوکار  
**مخزن:** [MrUtility01/network-learning-app](https://github.com/MrUtility01/network-learning-app)

برنامهٔ محلی یادگیری شبکه (FastAPI + SQLite + رابط فارسی RTL) با پشتیبانی ویندوز، لینوکس/مک، **PWA اندروید** و پروژهٔ **APK WebView**.

## قابلیت‌های نسخهٔ ۰.۴.۱

- ۲۹ فصل پایه + بستهٔ عمیق فصل ۱ + نمونهٔ فصل ۲۱
- درس، فلش‌کارت، سؤال (کلید فقط سمت سرور)، دستور، آزمایشگاه
- مدیریت و تأیید محتوا، عملیات گروهی، Import چندفصلی
- برنامه‌ریز شمسی، کارها، زمان‌سنج، گزارش، پشتیبان/بازیابی
- PWA قابل نصب روی اندروید + اسکلت پروژهٔ Android Studio

## ویندوز

1. Python 3.10+  
2. استخراج و اجرای `run_windows.bat`  
3. مرورگر: `http://127.0.0.1:8000`  
4. در اولین اجرا رمز محلی (حداقل ۱۲ نویسه)

لینوکس/مک: `./start_linux_mac.sh`

## اندروید

### سریع (PWA)
1. سرور را روی رایانه روشن کن.  
2. IP رایانه را پیدا کن.  
3. در Chrome گوشی: `http://IP:8000` → Add to Home screen.

### APK
پوشهٔ `android/` را در Android Studio باز کن و Debug APK بساز. راهنما: [`android/README_FA.md`](android/README_FA.md)

## ساخت فصل جدید

از [`Chapter_Authoring_Kit/`](Chapter_Authoring_Kit/) استفاده کن. قالب برای ویندوز و اندروید **یکسان** است.

```bash
python Chapter_Authoring_Kit/scripts/validate_chapter_pack.py path/to/chapter_folder
```

سپس ZIP را از داخل برنامه Import و در «مدیریت و تأیید محتوا» بررسی کن.

## ساختار

| مسیر | توضیح |
|------|--------|
| `app.py` | API و پایگاه داده |
| `static/` | UI + PWA (`manifest.webmanifest`, `sw.js`) |
| `content_pack/` | فصل ۱ و نمونهٔ ۲۱ |
| `Chapter_Authoring_Kit/` | قالب و اعتبارسنج فصل |
| `android/` | پروژهٔ WebView اندروید |
| `data/` | SQLite و رسانه (پس از اجرا) |

## امنیت

- فقط استفادهٔ محلی؛ برای اینترنت عمومی TLS و سخت‌سازی لازم است.
- محتوای Ethical Hacking باید دفاعی و قانونی باشد: `SECURITY_AND_ETHICAL_HACKING_FA.md`

## مجوز و مسئولیت

نمونهٔ آموزشی محلی است. صحت عملیاتی دستورات روی همهٔ نسخه‌های تجهیزات تضمین نشده؛ قبل از محیط عملیاتی بازبینی کن.
