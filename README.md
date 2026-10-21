# دانشنامه جامع شبکه — Network Learning App

**مسیر اصلی: نسخهٔ ویندوز ۰.۴.۳**  
**سازنده:** مهندس مسعود جوکار  
**مخزن:** [MrUtility01/network-learning-app](https://github.com/MrUtility01/network-learning-app)

برنامهٔ **محلی** یادگیری شبکه (FastAPI + SQLite + رابط فارسی RTL).
توسعه و توزیع رسمی از **ویندوز** جلو می‌رود؛ اندروید در این مخزن به‌صورت همراه (PWA / WebView) است.

---

## دانلود نسخهٔ کامل ویندوز (۰.۴.۳)

**فایل آماده:**

https://github.com/MrUtility01/network-learning-app/raw/main/new/Network_Learning_App_v0.4.3_FA.zip

**پوشهٔ بسته‌ها و فصل‌ها:**

https://github.com/MrUtility01/network-learning-app/tree/main/new

### اجرا روی ویندوز

1. ZIP را استخراج کن  
2. `run_windows.bat`  
3. مرورگر: `http://127.0.0.1:8000`  
4. در اولین اجرا رمز محلی (حداقل ۱۲ نویسه)

همراه نصب: content_pack فصل‌های **۱، ۲۱، ۳۰، ۳۱، ۳۲**  
سایر فصل‌ها از ZIPهای داخل `new/` با **واردکردن محتوا**

---

## قابلیت‌های مسیر ویندوز

- فهرست ۳۲ فصل + محتوا عمیق منتخب  
- درس، فلش‌کارت، سؤال، دستور، آزمایشگاه  
- مدیریت و تأیید محتوا، Import فصل  
- برنامه‌ریز شمسی، کارها، مرور، گزارش  
- پشتیبان / بازیابی محلی

---

## اندروید (همراه نسخهٔ ویندوز — نه جایگزین)

### ۱) PWA (پیشنهادی با همان سرور ویندوز)
1. سرور ویندوز روشن باشد  
2. در Chrome گوشی: `http://IP-رایانه:8000`  
3. Add to Home screen

### ۲) WebView به سرور ویندوز
پوشهٔ [`android/`](android/) — کلاینت به `http://IP:8000` وصل می‌شود.

### ۳) اپ بومی جدا (مخزن NetworkAll)
اگر APK کاملاً مستقل می‌خواهی (بدون ویندوز):

- مخزن: https://github.com/MrUtility01/NetworkAll  
- آخرین ساخت موفق APK: https://github.com/MrUtility01/NetworkAll/actions/runs/39691473803  
  (Artifacts → `EngineerJokar-APK-v1`)

> در **این** مخزن (`network-learning-app`) مسیر رسمی = **ویندوز ۰.۴.۳**.

---

## ساخت فصل

[`Chapter_Authoring_Kit/`](Chapter_Authoring_Kit/) — قالب برای Import در برنامهٔ ویندوز یکسان است.

---

## ساختار مخزن

| مسیر | توضیح |
|------|--------|
| `new/` | **نسخهٔ کامل ویندوز ۰.۴.۳ + ZIP فصل‌ها** |
| `run_windows.bat` | اجراگر ویندوز (نسخهٔ سبک ریشه) |
| `static/` | UI + PWA |
| `android/` | WebView وابسته به سرور ویندوز |
| `android_standalone/` | اسکلت Chaquopy (آزمایشی) |
| `Chapter_Authoring_Kit/` | ساخت فصل |

---

## امنیت

فقط استفادهٔ محلی. Ethical Hacking فقط دفاعی و قانونی: `SECURITY_AND_ETHICAL_HACKING_FA.md`

## وضعیت

جزئیات به‌روز: [`STATUS_WINDOWS_FIRST_FA.md`](STATUS_WINDOWS_FIRST_FA.md)
