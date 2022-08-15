package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
