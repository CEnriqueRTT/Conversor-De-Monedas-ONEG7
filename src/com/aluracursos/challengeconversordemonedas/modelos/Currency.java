package com.aluracursos.challengeconversordemonedas.modelos;

public class Currency {
    //Atributos
    private String base_code;
    private String target_code;
    private double conversion_rate;

    //Constructor con parámetros
    public Currency(CurrencyExchangeRateAPI currency){
        this.base_code = currency.base_code();
        this.target_code = currency.target_code();
        this.conversion_rate = currency.conversion_rate();
    }

    //Método getter
    public double getConversion_rate() {
        return conversion_rate;
    }

    @Override
    public String toString() {
        return "" + "conversion_rate=" + conversion_rate;
    }
}