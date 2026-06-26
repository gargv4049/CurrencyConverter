package com.vivek.currencyconverter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Currency Converter Project using Java Swing.
 *
 * Features:
 * 1. Convert amount from one currency to another.
 * 2. Swap currencies.
 * 3. Reset form.
 * 4. Input validation.
 * 5. Clean beginner-friendly Swing code.
 *
 * Note: Rates are sample offline rates relative to USD.
 * You can update the rates in the createRates() method.
 */
public class CurrencyConverter extends JFrame {

    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;
    private JLabel rateLabel;
    private final Map<String, Double> rates;
    private final DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");
    private final DecimalFormat rateFormat = new DecimalFormat("#,##0.0000");

    public CurrencyConverter() {
        rates = createRates();

        setTitle("Currency Converter - Java Swing Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 430);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        mainPanel.setBackground(new Color(245, 247, 250));

        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(createFormPanel(), BorderLayout.CENTER);
        mainPanel.add(createFooterPanel(), BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        headerPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Currency Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 64, 175));

        JLabel subtitleLabel = new JLabel("Java Swing Mini Project", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitleLabel.setForeground(new Color(75, 85, 99));

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);
        return headerPanel;
    }

    private JPanel createFormPanel() {
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(22, 25, 22, 25)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel amountLabel = createLabel("Enter Amount");
        amountField = new JTextField();
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        amountField.setToolTipText("Example: 1000");

        JLabel fromLabel = createLabel("From Currency");
        fromCurrencyBox = new JComboBox<>(rates.keySet().toArray(new String[0]));
        fromCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 15));
        fromCurrencyBox.setSelectedItem("USD - United States Dollar");

        JLabel toLabel = createLabel("To Currency");
        toCurrencyBox = new JComboBox<>(rates.keySet().toArray(new String[0]));
        toCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 15));
        toCurrencyBox.setSelectedItem("INR - Indian Rupee");

        JButton convertButton = createButton("Convert");
        JButton swapButton = createSecondaryButton("Swap");
        JButton resetButton = createSecondaryButton("Reset");

        convertButton.addActionListener(this::convertCurrency);
        swapButton.addActionListener(this::swapCurrencies);
        resetButton.addActionListener(this::resetForm);

        resultLabel = new JLabel("Result will appear here", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setForeground(new Color(22, 101, 52));

        rateLabel = new JLabel("Exchange rate will appear here", SwingConstants.CENTER);
        rateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        rateLabel.setForeground(new Color(107, 114, 128));

        addRow(cardPanel, gbc, 0, amountLabel, amountField);
        addRow(cardPanel, gbc, 1, fromLabel, fromCurrencyBox);
        addRow(cardPanel, gbc, 2, toLabel, toCurrencyBox);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(convertButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(resetButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(18, 8, 12, 8);
        cardPanel.add(buttonPanel, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(10, 8, 5, 8);
        cardPanel.add(resultLabel, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(2, 8, 8, 8);
        cardPanel.add(rateLabel, gbc);

        return cardPanel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);

        JLabel noteLabel = new JLabel("Note: This project uses sample offline rates. Update rates in code if needed.", SwingConstants.CENTER);
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        noteLabel.setForeground(new Color(107, 114, 128));
        footerPanel.add(noteLabel, BorderLayout.CENTER);

        return footerPanel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(new Color(31, 41, 55));
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(new Color(37, 99, 235));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(new Color(229, 231, 235));
        button.setForeground(new Color(31, 41, 55));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, JLabel label, JComponent component) {
        gbc.gridwidth = 1;
        gbc.gridy = row;

        gbc.gridx = 0;
        gbc.weightx = 0.30;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.70;
        panel.add(component, gbc);
    }

    private void convertCurrency(ActionEvent event) {
        try {
            String amountText = amountField.getText().trim();

            if (amountText.isEmpty()) {
                showError("Please enter an amount.");
                return;
            }

            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                showError("Amount must be greater than 0.");
                return;
            }

            String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
            String toCurrency = (String) toCurrencyBox.getSelectedItem();

            double fromRate = rates.get(fromCurrency);
            double toRate = rates.get(toCurrency);

            // Convert source amount to USD first, then USD to target currency.
            double amountInUSD = amount / fromRate;
            double convertedAmount = amountInUSD * toRate;
            double exchangeRate = toRate / fromRate;

            String fromCode = getCode(fromCurrency);
            String toCode = getCode(toCurrency);

            resultLabel.setText(amount + " " + fromCode + " = " + moneyFormat.format(convertedAmount) + " " + toCode);
            rateLabel.setText("1 " + fromCode + " = " + rateFormat.format(exchangeRate) + " " + toCode);

        } catch (NumberFormatException ex) {
            showError("Please enter a valid number only. Example: 2500");
        }
    }

    private void swapCurrencies(ActionEvent event) {
        Object from = fromCurrencyBox.getSelectedItem();
        Object to = toCurrencyBox.getSelectedItem();
        fromCurrencyBox.setSelectedItem(to);
        toCurrencyBox.setSelectedItem(from);
    }

    private void resetForm(ActionEvent event) {
        amountField.setText("");
        fromCurrencyBox.setSelectedItem("USD - United States Dollar");
        toCurrencyBox.setSelectedItem("INR - Indian Rupee");
        resultLabel.setText("Result will appear here");
        rateLabel.setText("Exchange rate will appear here");
        amountField.requestFocus();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private String getCode(String currencyText) {
        return currencyText.substring(0, 3);
    }

    private Map<String, Double> createRates() {
        Map<String, Double> currencyRates = new LinkedHashMap<>();

        // Rates relative to USD. Example: 1 USD = 83.20 INR.
        currencyRates.put("USD - United States Dollar", 1.00);
        currencyRates.put("INR - Indian Rupee", 83.20);
        currencyRates.put("EUR - Euro", 0.92);
        currencyRates.put("GBP - British Pound", 0.79);
        currencyRates.put("JPY - Japanese Yen", 151.35);
        currencyRates.put("AUD - Australian Dollar", 1.52);
        currencyRates.put("CAD - Canadian Dollar", 1.36);
        currencyRates.put("AED - UAE Dirham", 3.67);

        return currencyRates;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter app = new CurrencyConverter();
            app.setVisible(true);
        });
    }
}
