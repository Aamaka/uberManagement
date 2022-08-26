package africa.semicolon.ubermanagement.services;
import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.DriverDto;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
    public DriverDto getDriver(String location) throws UserException {
        Optional<Driver> driver = repository.findDriverByLocation(location);
        if(driver.isPresent()){
            return DriverDto.builder()
                    .name(driver.get().getDriverName())
                    .model(driver.get().getCarType())
                    .color(driver.get().getCarColour())
                    .phoneNumber(driver.get().getDriverContact())
                    .vehicleNumber(driver.get().getCarNumber())
                    .build();
        }else {
            throw new UserException("No available driver at your location", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @Override
    public DriverDto login(LoginDriverRequest request) throws UserException {
        Optional<Driver> driver = repository.findByEmail(request.getEmail());
        if(driver.isPresent()){
            if(driver.get().getPassword().equals(request.getPassword())){
                driver.get().setDriverName(driver.get().getDriverName());
                driver.get().setAddress(driver.get().getDriverName());
                driver.get().setLocation(request.getLocation());
                driver.get().setDriverContact(driver.get().getDriverContact());
                driver.get().setCarColour(driver.get().getCarColour());
                driver.get().setCarNumber(driver.get().getCarNumber());
                driver.get().setCarType(driver.get().getCarType());
                driver.get().setGender(driver.get().getGender());

                Driver saveDrive = repository.save(driver.get());
                DriverDto driverDto = new DriverDto();
                driverDto.setMessage("Welcome back, " + saveDrive.getDriverName());
                return driverDto;
            }
            throw new UserException("Incorrect Details", HttpStatus.NOT_FOUND);
        }

        throw new UserException("Driver does not exist", HttpStatus.NOT_FOUND);
    }

}
