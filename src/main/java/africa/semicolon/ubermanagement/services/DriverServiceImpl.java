package africa.semicolon.ubermanagement.services;
import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.LoginDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService{


    private final DriverRepository repository;

    @Override
    public RegisterDriverResponse register(RegisterDriverRequest request) throws UserException {
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
                .confirmPassword(request.getConfirmPassword())
                .location(request.getLocation())
                .build();
        if(request.getPassword().equals(request.getConfirmPassword())){
            Driver saved = repository.save(driver);
            RegisterDriverResponse response = new RegisterDriverResponse();
            Mapper.map(saved, response);
            return response;
        }else {
            throw new UserException("Password does not match", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @Override
    public LoginDriverResponse login(LoginDriverRequest request) {
        return null;
    }
}
