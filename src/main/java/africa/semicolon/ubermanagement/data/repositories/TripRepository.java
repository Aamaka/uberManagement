package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
