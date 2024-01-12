package datastructuresproject3;

/**
 *
 * @author Techno
 */
public class Movie {

    private int id;
    private String title;
    private String genres;

    public Movie(int id, String title, String genres) {
        this.id = id;
        this.title = title;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        // Returns the title of the movie when converted to a string
        return this.title;
    }

}
