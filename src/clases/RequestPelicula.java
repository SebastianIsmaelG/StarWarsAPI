package clases;
import java.util.List;

public record RequestPelicula(String title, int episode_id, String opening_crawl, String director, String producer, String release_date) {
}


record Peliculas(List<RequestPelicula> results) {

}
