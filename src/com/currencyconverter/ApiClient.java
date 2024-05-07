package com.currencyconverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/%s/latest/%s";

    public static JsonObject fetchExchangeRates(String apiKey, String baseCurrency) {
        try {
            URL url = new URL(String.format(API_URL, apiKey, baseCurrency));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonObject ratesJson = JsonParser.parseString(response.toString()).getAsJsonObject();
            return ratesJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}