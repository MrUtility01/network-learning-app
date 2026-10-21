@echo off
setlocal
cd /d "%~dp0"
where py >nul 2>nul
if %errorlevel%==0 (set PY=py -3) else (set PY=python)
if not exist .venv\Scripts\python.exe (
  echo Creating a local Python environment...
  %PY% -m venv .venv
  if errorlevel 1 goto error
)
echo Installing required packages if needed...
.venv\Scripts\python.exe -m pip install --disable-pip-version-check -r requirements.txt
if errorlevel 1 goto error
start "Network Learning App" http://127.0.0.1:8000
.venv\Scripts\python.exe -m uvicorn app:app --host 127.0.0.1 --port 8000
if errorlevel 1 goto error
goto end
:error
echo.
echo Startup failed. Install Python 3.10+ and check your internet connection for first-time package installation.
pause
:end
endlocal
