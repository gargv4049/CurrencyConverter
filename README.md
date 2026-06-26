# Currency Converter - Java Swing Project

This is a beginner-friendly Java Swing mini project for converting currency values.

## Features

- Convert amount from one currency to another
- Swap source and target currencies
- Reset form
- Input validation
- Clean Java Swing GUI
- Offline sample exchange rates

## Project Structure

```text
CurrencyConverterSwing/
├── src/
│   └── com/
│       └── vivek/
│           └── currencyconverter/
│               └── CurrencyConverter.java
├── run.bat
├── run.sh
└── README.md
```

## How to Run in Windows CMD / PowerShell

Open terminal inside the project folder and run:

```bash
javac -d out src/com/vivek/currencyconverter/CurrencyConverter.java
java -cp out com.vivek.currencyconverter.CurrencyConverter
```

Or double-click/run:

```bash
run.bat
```

## How to Run in Linux / macOS

```bash
chmod +x run.sh
./run.sh
```

## How to Open in Eclipse

1. Open Eclipse.
2. Go to `File > New > Java Project`.
3. Project name: `CurrencyConverterSwing`.
4. Copy the `src` folder from this project into your Eclipse project.
5. Right-click `CurrencyConverter.java`.
6. Click `Run As > Java Application`.

## Important Note

This project uses sample offline exchange rates. Real exchange rates keep changing.
To update rates, open:

```text
src/com/vivek/currencyconverter/CurrencyConverter.java
```

Then update values inside the `createRates()` method.
