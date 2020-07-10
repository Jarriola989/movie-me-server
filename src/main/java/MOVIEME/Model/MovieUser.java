package MOVIEME.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class MovieUser {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Column(unique=true)
    private String username;
    @NotNull
    @Column(unique=true)
    private String email;
    @NotNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<MovieList> movieListsOwned;

    @ManyToMany
    private List<MovieList> movieLists;


    public MovieUser() {
    }

    public MovieUser(int id, String firstName, String lastName, String username, String email, String password, List<MovieList> movieListsOwned, List<MovieList> movieLists) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.movieListsOwned = movieListsOwned;
        this.movieLists = movieLists;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MovieList> getMovieListsOwned() {
        return movieListsOwned;
    }

    public void setMovieListsOwned(List<MovieList> movieListsOwned) {
        this.movieListsOwned = movieListsOwned;
    }

    public List<MovieList> getMovieLists() {
        return movieLists;
    }

    public void setMovieLists(List<MovieList> movieLists) {
        this.movieLists = movieLists;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
