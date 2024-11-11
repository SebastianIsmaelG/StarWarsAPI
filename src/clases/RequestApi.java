package clases;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequestApi {
    static String url = "https://swapi.dev/api/films/";
    public class PeliculaService{

        public static List<String> obtenerTitulos() throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Deserializar JSON en un objeto Peliculas
            Peliculas peliculas = new Gson().fromJson(response.body(), Peliculas.class);

            // Obtener y retornar solo los títulos de las películas
            return peliculas.results().stream()
                    .map(RequestPelicula::title)
                    .collect(Collectors.toList());
        }
    }
    public RequestPelicula buscar(int numeroPelicula) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url+numeroPelicula+"/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body()); //resultado

        return new Gson().fromJson(response.body(), RequestPelicula.class);
    }
}
