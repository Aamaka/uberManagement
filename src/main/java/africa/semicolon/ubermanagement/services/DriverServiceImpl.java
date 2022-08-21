package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.LoginDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService{


    private final DriverRepository repository;

    @Override
    public RegisterDriverResponse register(RegisterDriverRequest request) {
        Driver driver = Driver.builder()
                .driverName(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .driverContact(request.getPhoneNumber())
                .carType(request.getCarType())
                .carNumber(request.getCarNumber())
                .carColour(request.getCarColour())
                .gender(request.getGender())
                .password(request.getPassword())
                .location(request.getLocation())
                .build();
        Driver saved = repository.save(driver);
        RegisterDriverResponse response = new RegisterDriverResponse();
        Mapper.map(saved, response);

        return response;
    }

    @Override
    public LoginDriverResponse login(LoginDriverRequest request) {
        return null;
    }
}
