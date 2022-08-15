package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
