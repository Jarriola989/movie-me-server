package MOVIEME.Repository;

import MOVIEME.Model.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList, Integer> {
}
