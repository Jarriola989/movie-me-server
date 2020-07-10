package MOVIEME.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int movieId;
    @NotNull
    private String name;
    @NotNull
    private String imgUrl;
    @NotNull
    private Date release;
    @NotNull
    private Boolean watched;
    @JsonIgnore
    @ManyToOne
    private MovieList movieList;

    public Movie(int id, int movieId, String name, String imgUrl, Date release, Boolean watched, MovieList movieList) {
        this.id = id;
        this.movieId = movieId;
        this.name = name;
        this.imgUrl = imgUrl;
        this.release = release;
        this.watched = watched;
        this.movieList = movieList;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }
}
