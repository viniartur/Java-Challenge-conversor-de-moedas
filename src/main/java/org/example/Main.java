package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Saudações do programa e seleção de moeda
        System.out.println("""
                Seja bem vindo ao conversor de moedas, selecione abaixo a moeda que vai ser convertida
                Opções: 
                BRL
                USD
                EUR
                GBPB
                AUD
                CAD
                """);

        Scanner scanner = new Scanner(System.in);
        String moedaBase = scanner.nextLine();

        System.out.println("Agora selecione o valor desta moeda para ser convertida");
        float valor = scanner.nextFloat();
        scanner.nextLine(); // Consumir a nova linha remanescente

        System.out.println("""
                Agora, escolha a moeda que será convertida a um valor equivalente à moeda anterior
                Opções: 
                BRL
                USD
                EUR
                GBP
                AUD
                CAD
                """);

        String moedaDestino = scanner.nextLine();

        try {
            // Chama a API para obter os dados da conversão
            ConversionData conversionData = ApiService.converter(moedaBase, moedaDestino, valor);

            // Exibe os resultados
            System.out.println("Resultado da conversão:");
            System.out.println(conversionData);
        } catch (Exception e) {
            System.out.println("Erro na conversão: " + e.getMessage());
        }
    }
}