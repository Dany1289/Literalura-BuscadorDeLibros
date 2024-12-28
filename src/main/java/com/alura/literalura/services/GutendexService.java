package com.alura.literalura.services;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexService {

    private final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS) // Configura para seguir redirecciones automáticamente
            .build();

    public String getBooks(String keyword, String language) {
        StringBuilder url = new StringBuilder("https://gutendex.com/books/");
        boolean hasParams = false;

        if (keyword != null && !keyword.isBlank()) {
            url.append("?search=").append(keyword);
            hasParams = true;
        }

        if (language != null && !language.isBlank()) {
            url.append(hasParams ? "&" : "?").append("languages=").append(language);
        }

        System.out.println("URL generada: " + url); // Depuración
        return sendRequest(url.toString());
    }

    public String listFirstBooks(int cantidad) {
        String url = "https://gutendex.com/books/?page=1&limit=" + cantidad;
        return sendRequest(url);
    }

    public String getBookDetails(int id) {
        String url = "https://gutendex.com/books/" + id;
        return sendRequest(url);
    }

    private String sendRequest(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else if (response.statusCode() == 301 || response.statusCode() == 302) {
                String newUrl = response.headers().firstValue("Location").orElse("Desconocido");
                return "Redirigido a: " + newUrl;
            } else {
                return "Error en la solicitud: Código de estado " + response.statusCode();
            }
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
