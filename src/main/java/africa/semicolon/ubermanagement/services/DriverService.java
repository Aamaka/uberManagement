package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.LoginDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {
    RegisterDriverResponse register(RegisterDriverRequest request);
    LoginDriverResponse login(LoginDriverRequest request);
}
