@echo off
setlocal
cd /d "%~dp0"
where py >nul 2>nul
if %errorlevel%==0 (set PY=py -3) else (set PY=python)
echo IMPORTANT: Close the Network Learning App server window before continuing.
%PY% reset_local_password.py
pause
endlocal
