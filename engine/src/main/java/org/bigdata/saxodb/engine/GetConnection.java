package org.bigdata.saxodb.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*CLASE TOMADA PARA CONSULTA, NO TOMAR EN CUENTA, LUEGO LA BORRO*/

public class GetConnection {
    public Object handle(String[] args) {
        try {
            // Crea la conexión HTTP
            URL url = new URL("http://www.ejemplo.com/estadisticas");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Añade cabeceras opcionales
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer mi-token-de-acceso");

            // Envía la solicitud y obtiene la respuesta
            int request = connection.getResponseCode();
            if (request == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder JSONrequest = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    JSONrequest.append(line);
                }
                reader.close();

                // Imprime la respuesta JSON
                System.out.println(JSONrequest.toString());
            } else {
                System.out.println("Error: " + request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
