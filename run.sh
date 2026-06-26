#!/bin/bash
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/com/vivek/currencyconverter/CurrencyConverter.java
if [ $? -ne 0 ]; then
  echo "Compilation failed. Please check if JDK is installed."
  exit 1
fi
java -cp out com.vivek.currencyconverter.CurrencyConverter
