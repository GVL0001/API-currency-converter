package com.currencyconverter;

import com.google.gson.JsonObject;

public class CurrencyConverter {
    private static final String API_KEY = "ce1f2857a50d3e6d612861f1";

    public void convert(Currency baseCurrency, Currency[] targetCurrencies, double amount) {
        JsonObject ratesJson = ApiClient.fetchExchangeRates(API_KEY, baseCurrency.getCode());

        for (Currency targetCurrency : targetCurrencies) {
            double rate = ratesJson.get("conversion_rates").getAsJsonObject().get(targetCurrency.getCode()).getAsDouble();
            double convertedAmount = amount * rate;
            System.out.printf("%f %s = %f %s%n", amount, baseCurrency.getCode(), convertedAmount, targetCurrency.getCode());
        }
    }
}