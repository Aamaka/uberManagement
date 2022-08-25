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

import javax.transaction.Transactional;
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
            Driver drive = driver.get();
            return DriverDto.builder()
                    .name(drive.getDriverName())
                    .model(drive.getCarType())
                    .color(drive.getCarColour())
                    .phoneNumber(drive.getDriverContact())
                    .vehicleNumber(drive.getCarNumber())
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
                if(driver.get().getLocation() != null){

                    Driver driver1 = new Driver();
                    driver1.setLocation(request.getLocation());
                    Driver drive = repository.save(driver1);
                    DriverDto driverDto = new DriverDto();
                    driverDto.setMessage("Welcome back, " + drive.getDriverName());
                    return driverDto;
                }
                throw new UserException("Driver not found", HttpStatus.NOT_FOUND);
            }
            throw new UserException("Incorrect Details", HttpStatus.NOT_FOUND);
        }

        throw new UserException("Driver does not exist", HttpStatus.NOT_FOUND);
    }

}
