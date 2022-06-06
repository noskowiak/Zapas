package pl.zapas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findLocationByName(String name);
}
