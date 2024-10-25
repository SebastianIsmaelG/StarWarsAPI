package clases;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class RequestApi {
    String url = "https://swapi.dev/api/films/";
    public RequestApi buscarTodos() throws IOException, InterruptedException {
        ArrayList titulos = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        var e = new Gson().fromJson(response.body(), RequestApi.class);
        System.out.println(e);
        return e;
        //for (int i = 0; i <  ; i++) {
            //titulos.add() episodio mas id
       //}
    }
    public RequestPelicula buscar(int numeroPelicula) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url+numeroPelicula+"/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body()); //resultado

        return new Gson().fromJson(response.body(), RequestPelicula.class);
    }
}
