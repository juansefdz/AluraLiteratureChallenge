package com.juansefdz.LiterAlura.infraestructure.api;

import com.google.gson.Gson;
import com.juansefdz.LiterAlura.api.dto.response.GutendexResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexApi {

    private static final String BASE_URL = "https://gutendex.com/books/?search=";
    private final Gson gson;

    public GutendexApi() {
        this.gson = new Gson();
    }

    public GutendexResponse searchBooksByTitle(String searchTerm) {
        try {
            String encodedSearchTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
            String url = BASE_URL + encodedSearchTerm;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), GutendexResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener datos de Gutendex API", e);
        }
    }
}


