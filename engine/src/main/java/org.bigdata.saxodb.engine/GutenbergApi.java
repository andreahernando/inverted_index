package org.bigdata.saxodb.engine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutenbergApi {
    URL url = new URL("https://gnikdroy.pythonanywhere.com/api/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();

    public GutenbergApi() throws IOException {
    }
}
