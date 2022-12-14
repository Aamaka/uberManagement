package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findDriverByLocation(String location);

    Optional<Driver> findDriverByEmail(String email);

    boolean existsByEmail(String email);


}
