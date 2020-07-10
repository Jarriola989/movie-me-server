package MOVIEME.Repository;

import MOVIEME.Model.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieUserRepository extends JpaRepository<MovieUser, Integer> {
}
