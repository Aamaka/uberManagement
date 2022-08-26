package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.DriverDto;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.exception.UserException;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {
    RegisterDriverResponse register(RegisterDriverRequest request) throws UserException;

    DriverDto getDriver(String location) throws UserException;
    DriverDto login(LoginDriverRequest request) throws UserException;
}
