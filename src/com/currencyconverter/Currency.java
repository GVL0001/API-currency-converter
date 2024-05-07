package com.currencyconverter;

public enum Currency {
    ARS("Peso argentino"),
    BOB("Boliviano boliviano"),
    BRL("Real brasileño"),
    CLP("Peso chileno"),
    COP("Peso colombiano"),
    USD("Dólar estadounidense");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.name();
    }

    public String getName() {
        return this.name;
    }
}