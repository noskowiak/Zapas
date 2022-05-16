package pl.zapas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
