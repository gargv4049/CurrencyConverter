@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -d out src\com\vivek\currencyconverter\CurrencyConverter.java
if errorlevel 1 (
    echo Compilation failed. Please check if JDK is installed.
    pause
    exit /b 1
)
java -cp out com.vivek.currencyconverter.CurrencyConverter
pause
