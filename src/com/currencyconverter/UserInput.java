package com.currencyconverter;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Currency getBaseCurrency() {
        while (true) {
            System.out.println("Seleccione la moneda base:");
            displayCurrencyOptions();
            System.out.println("0. Regresar al menú anterior");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("0")) {
                return null; // Regresar al menú anterior
            }

            Currency baseCurrency = Arrays.stream(Currency.values())
                    .filter(c -> c.getCode().equals(input))
                    .findFirst()
                    .orElse(null);

            if (baseCurrency != null) {
                return baseCurrency;
            } else {
                System.out.println("Código de moneda inválido. Por favor, ingrese un código válido.");
            }
        }
    }

    public Currency[] getTargetCurrencies() {
        System.out.print("Ingrese las monedas de destino (códigos de 3 letras separados por comas): ");
        String[] codes = scanner.nextLine().toUpperCase().split(",");
        return Arrays.stream(codes)
                .map(code -> Arrays.stream(Currency.values())
                        .filter(c -> c.getCode().equals(code))
                        .findFirst()
                        .orElse(null))
                .filter(c -> c != null)
                .toArray(Currency[]::new);
    }

    public double getAmount() {
        return getDoubleInput("Ingrese el monto a convertir: ");
    }

    private double getDoubleInput(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
        return value;
    }

    private void displayCurrencyOptions() {
        System.out.println("Opciones de moneda:");
        for (Currency currency : Currency.values()) {
            System.out.println(currency.getCode() + " - " + currency.getName());
        }
    }
}