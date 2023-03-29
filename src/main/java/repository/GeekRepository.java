package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import beans.Movies;
@Repository

public interface GeekRepository extends JpaRepository<Movies, Long> { }