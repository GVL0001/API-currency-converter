package com.currencyconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Bienvenido al conversor de divisas!");

        boolean exit = false;
        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir divisas");
            System.out.println("0. Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    Currency baseCurrency = userInput.getBaseCurrency();
                    if (baseCurrency != null) {
                        Currency[] targetCurrencies = userInput.getTargetCurrencies();
                        double amount = userInput.getAmount();
                        converter.convert(baseCurrency, targetCurrencies, amount);
                    }
                    break;
                case "0":
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}