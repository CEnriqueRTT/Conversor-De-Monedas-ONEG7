package com.aluracursos.challengeconversordemonedas.modelos;

public record CurrencyExchangeRateAPI(String base_code,
                                      String target_code,
                                      double conversion_rate) {
}