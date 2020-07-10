package MOVIEME.Controller;

import MOVIEME.Model.MovieList;
import MOVIEME.Repository.MovieListRepository;
import MOVIEME.Repository.MovieUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
@CrossOrigin
public class MovieListController {

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    MovieUserRepository movieUserRepository;

    @GetMapping(path="{id}/movie-lists")
    public List<MovieList> getMovieListsByUser(@PathVariable("id") Integer userId){
        return movieUserRepository.findById(userId).map(user -> {
            return user.getMovieLists();
        }).orElseThrow(() -> new Error("User " + userId + " not found!"));
    }
}
