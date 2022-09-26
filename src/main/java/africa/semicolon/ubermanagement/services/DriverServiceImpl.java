package africa.semicolon.ubermanagement.services;
import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Vehicle;
import africa.semicolon.ubermanagement.data.models.enums.DriverStatus;
import africa.semicolon.ubermanagement.data.repositories.UserRepository;
import africa.semicolon.ubermanagement.data.repositories.VehicleRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.GetDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.*;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.PaymentRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class DriverServiceImpl implements DriverService{


    private final DriverRepository repository;
    private final VehicleRepository vehicleRepository;
    private  final UserRepository userRepository;

    @Override
    public RegisterDriverResponse register(RegisterDriverRequest request) throws UserException {
        if(repository.existsByEmail(request.getEmail()))throw new UserException("User already exist", HttpStatus.NOT_ACCEPTABLE);

        Driver driver = Driver.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .password(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .build();
        RegisterDriverResponse response = new RegisterDriverResponse();
        if(request.getPassword().equals(request.getConfirmPassword())){
            Driver saved = repository.save(driver);

            response.setMessage("Your registration was successful Welcome " + saved.getName());
        }else {
            response.setMessage("Password Mismatch");
        }

        return response;
    }

    @Override
    public Driver getDriver(String location) throws UserException {
        List<Driver> availableDrivers =  new ArrayList<>();
        List<Driver> driverList = repository.findDriverByLocation(location);
        log.info("{}", driverList.size());
        log.info("{}", repository.findAll());
        for (Driver driver : driverList) {
            if (driver.getDriverStatus().equals(DriverStatus.AVAILABLE)) {
                availableDrivers.add(driver);
            }
        }
        if (availableDrivers.size() == 0){
            throw new UserException("No available Driver", HttpStatus.EXPECTATION_FAILED);
        }
        if(availableDrivers.size() > 1){
            SecureRandom random = new SecureRandom();
            return availableDrivers.get(random.nextInt(availableDrivers.size()));

        }else {
            return availableDrivers.get(0);
        }

    }

    private DriverDto getDriverDto(Driver assignDriver) throws UserException {
        Optional<Vehicle> vehicle = vehicleRepository.findByDriver(assignDriver);
        if(vehicle.isPresent()){
            return DriverDto.builder()
                    .name(assignDriver.getName())
                    .phoneNumber(assignDriver.getPhoneNumber())
                    .model(vehicle.get().getModel())
                    .color(vehicle.get().getColour())
                    .vehicleNumber(vehicle.get().getVehicleNumber())
                    .build();
        }
        throw new UserException("Driver's Vehicle is faulty",  HttpStatus.NOT_FOUND);
    }

    @Override
    public LoginDriverResponse login(LoginDriverRequest request) throws UserException {
        Optional<Driver> driver = repository.findDriverByEmail(request.getEmail());
        if(driver.isPresent()){
            if(driver.get().getPassword().equals(request.getPassword())){
                driver.get().setLocation(request.getLocation());
                driver.get().setDriverStatus(request.getDriverStatus());
                repository.save(driver.get());
                LoginDriverResponse response = new LoginDriverResponse();
                response.setMessage("Welcome back "+ driver.get().getName());
                return response;
            }
            throw new UserException("Invalid details", HttpStatus.NOT_ACCEPTABLE);
        }

        throw new UserException("Driver does not exist", HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public BookingResponse bookingDetails(String location) {
//        Optional<User> user =
        return null;
    }

    @Override
    public PaymentResponse payment(PaymentRequest request) {
        return null;
    }



}
