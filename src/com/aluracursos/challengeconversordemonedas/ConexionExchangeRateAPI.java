package com.aluracursos.challengeconversordemonedas;

import com.aluracursos.challengeconversordemonedas.modelos.Currency;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionExchangeRateAPI {
    public static Currency convertidor(String divisa1, String divisa2, Double valorMoneda)  {
        //Realizando la conexión con la API de ExchangeRate-API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/03cae476b5b1bcfa12b41e7b/pair/"+ divisa1 + "/" + divisa2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;

        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), Currency.class);
    }
}