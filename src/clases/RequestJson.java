package clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class RequestJson {
    public void guardarJson(RequestPelicula pelicula){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter write = new FileWriter(pelicula.title()+".json");
            write.write(gson.toJson(pelicula));
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
