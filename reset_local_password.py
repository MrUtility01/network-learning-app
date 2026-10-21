from pathlib import Path
import sqlite3

ROOT = Path(__file__).resolve().parent
DB = ROOT / "data" / "network_learning.db"

print("بازنشانی رمز محلی برنامهٔ دانشنامه جامع شبکه")
print("ابتدا مطمئن شو سرور برنامه بسته است.")
if not DB.exists():
    print("پایگاه‌داده پیدا نشد؛ برنامه را یک بار اجرا کن و دوباره تلاش کن.")
    raise SystemExit(1)
confirm = input("برای پاک‌کردن فقط تنظیمات ورود و ساخت دوبارهٔ رمز، عبارت RESET را وارد کن: ").strip()
if confirm != "RESET":
    print("لغو شد؛ هیچ تغییری انجام نشد.")
    raise SystemExit(0)
with sqlite3.connect(DB) as conn:
    conn.execute("DELETE FROM settings WHERE key IN ('password_hash','auth_secret')")
print("انجام شد. محتوا، فصل‌ها، پیشرفت و تاریخچه حذف نشده‌اند.")
print("برنامه را دوباره اجرا کن و یک رمز جدید حداقل ۱۲ نویسه‌ای بساز.")
