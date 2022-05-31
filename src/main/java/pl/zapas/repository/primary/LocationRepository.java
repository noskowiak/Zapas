package pl.zapas.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zapas.entity.primary.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
