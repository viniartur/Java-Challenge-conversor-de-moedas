package org.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    static String webService = "https://v6.exchangerate-api.com/v6/9dede3e5a8f1b3564385ef32/pair/";
    static int codigoSucesso = 200;

    public static ConversionData converter(String moedaBase, String moedaDestino, float valor) throws Exception {
        // Construir URL dinamicamente com base nas entradas
        String urlParaChamada = webService + moedaBase + "/" + moedaDestino + "/" + valor;

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            // Verificar o código de resposta HTTP
            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String jsonEmString = Util.converterJsonEmString(resposta);

            Gson gson = new Gson();
            // Deserializar a resposta para um objeto ConversionData
            ConversionData conversionData = gson.fromJson(jsonEmString, ConversionData.class);

            return conversionData;

        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }
}
