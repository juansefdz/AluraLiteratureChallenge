package com.juansefdz.LiterAlura.infraestructure.api;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Service
public class GutendexApi {

    private static final String BASE_URL = "https://gutendex.com/books/?search=";

    public String getBooksData(String searchTerm) {
        try {

            String encodedSearchTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
            String url = BASE_URL + encodedSearchTerm;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
