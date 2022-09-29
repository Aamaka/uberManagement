package africa.semicolon.ubermanagement.data.repositories;

import africa.semicolon.ubermanagement.data.models.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    void findUserByEmail() {
        Optional<User> optionalUser = userRepository.findUserByEmail("bola@gmail.com");
        log.info("{}", optionalUser.get().getName());
        assertThat(optionalUser.isPresent()).isTrue();
    }
}