
import clases.RequestApi;
import clases.RequestJson;
import clases.RequestPelicula;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        RequestApi consulta = new RequestApi();

        System.out.println("Hola esta es la API de star wars, contiene informacion sobre las siguientes peliculas: ");
        System.out.println("--------------");
        //necesito title y episode id
        RequestApi peliculasDisponibles = consulta.buscarTodos();
        System.out.println("--------------");

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el numero de pelicula a ver: ");
        try {
            var numero = Integer.valueOf(lectura.nextLine());
            RequestPelicula pelicula = consulta.buscar(numero);
            System.out.println(pelicula);
            RequestJson generarArchivo = new RequestJson();
            generarArchivo.guardarJson(pelicula);
        } catch (Exception e) {
            System.out.println("Numero no encontrado");
        }





    }
}

