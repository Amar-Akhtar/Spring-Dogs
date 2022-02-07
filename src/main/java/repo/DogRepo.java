package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Long> {

}
