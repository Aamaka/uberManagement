package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findTripsByDriver(Driver driver);

    List<Trip> findTripsByUser(User user);
    Optional<Trip> findTripByUser(User user);
}
