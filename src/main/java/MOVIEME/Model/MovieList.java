package MOVIEME.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class MovieList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private MovieUser owner;

    @ManyToMany(mappedBy = "movieLists")
    private List<MovieUser> users;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movieList")
    private List<Movie> movies;

    public MovieList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieUser getOwner() {
        return owner;
    }

    public void setOwner(MovieUser owner) {
        this.owner = owner;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<MovieUser> getUsers() {
        return users;
    }

    public void setUsers(List<MovieUser> users) {
        this.users = users;
    }
}
