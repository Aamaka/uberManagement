package africa.semicolon.ubermanagement.services;
import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.data.models.enums.DriverStatus;
import africa.semicolon.ubermanagement.data.repositories.TripRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.*;
import africa.semicolon.ubermanagement.dtos.driver.responses.*;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.dtos.user.requests.PaymentRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static africa.semicolon.ubermanagement.validation.ValidateEmail.validateEmail;

@AllArgsConstructor
@Service
@Slf4j
public class DriverServiceImpl implements DriverService{


    private final DriverRepository repository;
    private final TripRepository tripRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterDriverResponse register(RegisterDriverRequest request) throws UserException {
        if(repository.existsByEmail(request.getEmail()))throw new UserException("User already exist", HttpStatus.NOT_ACCEPTABLE);
        if(validateEmail(request.getEmail())){
            Driver driver = modelMapper.map(request, Driver.class);
            driver.setPassword(passwordEncoder.encode(request.getPassword()));
            RegisterDriverResponse response = new RegisterDriverResponse();
            if(request.getPassword().equals(request.getConfirmPassword())){
                Driver saved = repository.save(driver);

                response.setMessage("Your registration was successful Welcome " + saved.getName());
            }else {
                response.setMessage("Password Mismatch");
            }

            return response;
        }
       throw new UserException("Invalid email syntax", HttpStatus.NOT_ACCEPTABLE);
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

    @Override
    public LoginDriverResponse login(LoginDriverRequest request) throws UserException {
        Optional<Driver> driver = repository.findDriverByEmail(request.getEmail());
        if(driver.isPresent()){
            if(passwordEncoder.matches(request.getPassword(), driver.get().getPassword())){
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
        return null;
    }

    @Override
    public PaymentResponse payment(PaymentRequest request) {
        return null;
    }

    @Override
    public List<Trip> getAllTrips(GetTripHistory history) throws UserException {
        Optional<Driver> driver = repository.findDriverByEmail(history.getEmail());
        if(driver.isPresent()){
            List<Trip> trip =  tripRepository.findTripsByDriver(driver.get());
            if(!trip.isEmpty()){
                return trip;
            }else
                throw new UserException("Driver does not have any trip", HttpStatus.NOT_FOUND);
        }else {
            throw new UserException("Driver does not exist", HttpStatus.NOT_FOUND);
        }

    }


}
