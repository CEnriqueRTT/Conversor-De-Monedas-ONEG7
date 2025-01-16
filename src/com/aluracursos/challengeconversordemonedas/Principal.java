package com.aluracursos.challengeconversordemonedas;

//Link de la página web para obtener la API ► https://www.exchangerate-api.com/

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Menú de bienvenida
        String monedas = """
               *****************************************************
                      BIENVENIDO AL CONVERSOR DE MONEDAS 2024
                                
                     Ejemplos de divisas para la conversión:
                         1. [ARS] - Peso argentino
                         2. [BOB] - Boliviano boliviano
                         3. [BRL] - Real brasileño
                         4. [CLP] - Peso chileno
                         5. [COP] - Peso colombiano
                         6. [USD] - Dólar estadounidense
               *****************************************************
                """;
        System.out.println(monedas);

        Scanner lectura = new Scanner(System.in);
        String respuesta = "";

        do {
            //Solicitar código de las monedas
            System.out.println("Digite el código de la moneda de origen");
            String divisa1 = lectura.nextLine().toUpperCase();
            System.out.println("Digite el código de la moneda de destino");
            String divisa2 = lectura.nextLine().toUpperCase();

            //Solicitar el monto de la moneda y validar la entrada
            System.out.println("Ingrese el monto de la moneda de origen");
            double valorMoneda;

            try {
                valorMoneda = Double.parseDouble(lectura.nextLine());
            }catch (NumberFormatException  e)  {
                System.out.println("Error: Ingrese de forma correcta el monto de la moneda de origen.");
                continue;
            }

            //Conexión a la API y cálculo de conversión
            ConexionExchangeRateAPI conexionApi = new ConexionExchangeRateAPI();
            var converter = ConexionExchangeRateAPI.convertidor(divisa1, divisa2, valorMoneda);
            double resultado = converter.getConversion_rate() * valorMoneda;

            //Mostrar el resultado de la conversión
            System.out.println("\n=====================================================");
            System.out.println("   La conversión de " + valorMoneda + " " + divisa1 + " es igual a: " + resultado + " " + divisa2);
            System.out.println("=====================================================\n");

            //Validar si se desea intentar de nuevo
            do {
                System.out.println("¿Desea intentarlo de nuevo? [SI / NO]");
                respuesta = lectura.nextLine().trim(); //Elimina espacios innecesarios
                System.out.println();

                if (respuesta.equalsIgnoreCase("no")) {
                    System.out.println("¡Adiós!, que tenga un buen día.");
                    break; //Para salir del bucle interno y externo si se digita "no"
                } else if (!respuesta.equalsIgnoreCase("si")) {
                    System.out.println("Entrada inválida. Por favor, responda únicamente con 'SI' o 'NO'.\n");
                }
            } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")); //Repetir hasta recibir "si" o "no"
        } while (respuesta.equalsIgnoreCase("si")); //Continuar si la respuesta es "si"

        lectura.close();
    }
}