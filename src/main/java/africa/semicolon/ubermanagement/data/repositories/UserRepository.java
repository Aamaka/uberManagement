package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
