package api;

import Serialize.Json;
import Model.Metadata;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutenbergApi {
    public static final int HTTP_OK = 200;
    public static final String API_BASE_URI = "https://gnikdroy.pythonanywhere.com/api/";

    private static HttpClient client;

    public static void init() throws ApiException {
        client = HttpClient.newHttpClient();
    }

    public static Metadata document(Integer id) throws ApiException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gnikdroy.pythonanywhere.com/api/book/" + id + "/"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != HTTP_OK) throw new ApiException(response.statusCode(), response.body());
            System.out.println(response.body());
            return Json.fromJson(response.body(), Metadata.class);

        } catch (IOException | InterruptedException e) {
            throw new ApiException(500, e.getMessage());
        }
    }
}
