package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.data.models.User;
import africa.semicolon.ubermanagement.data.models.Vehicle;
import africa.semicolon.ubermanagement.data.repositories.TripRepository;
import africa.semicolon.ubermanagement.data.repositories.UserRepository;
import africa.semicolon.ubermanagement.dtos.user.requests.*;
import africa.semicolon.ubermanagement.dtos.user.responses.*;
import africa.semicolon.ubermanagement.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserServices{
    private  final UserRepository userRepository;
    private final DriverService driverService;
    private final TripRepository tripRepository;
    private final VehicleService vehicleService;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) throws UserException {
        if(userRepository.existsByEmail(request.getEmail()))throw new UserException("User already exist", HttpStatus.NOT_ACCEPTABLE);
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .build();
        CreateUserResponse response = new CreateUserResponse();
        if(request.getPassword().equals(request.getConfirmPassword())){
            User saved = userRepository.save(user);

            response.setMessage("Your registration was successful Welcome " + saved.getName());
        }else {
            response.setMessage("Password Mismatch");
        }
        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        LoginUserResponse response = new LoginUserResponse();
        if(user.isPresent()){
            if(user.get().getPassword().equals(request.getPassword())){
                response.setMessage("Welcome "+ user.get().getName());
            }else {
                response.setMessage("Incorrect Details");
            }
        }else {
            response.setMessage("User does not exist");
        }
        return response;
    }

    @Override
    public BookUserResponse book(BookUserRequest request) throws UserException {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            Driver driver = driverService.getDriver(request.getLocation());
            Trip trip = Trip.builder()
                    .pickUpAddress(request.getPickUpAddress())
                    .dropOffAddress(request.getDropOffAddress())
                    .user(user.get())
                    .driver(driver)
                    .time(LocalDateTime.now())
                    .location(request.getLocation())
                    .build();
            Trip saved = tripRepository.save(trip);
            Vehicle vehicle = vehicleService.getVehicleByDriver(driver);

            return buildBookTripResponse(trip, saved, vehicle);
        }
        throw new UserException("Invalid email", HttpStatus.NOT_FOUND);
    }

    private BookUserResponse buildBookTripResponse(Trip trip, Trip saved, Vehicle vehicle) {
        return BookUserResponse.builder()
                .message("you have been connected to your trip from " + saved.getPickUpAddress() + " has been ordered")
                .driverName(saved.getDriver().getName())
                .driverPhoneNumber(saved.getDriver().getPhoneNumber())
                .dateTime(trip.getTime())
                .vehicleModel(vehicle.getModel())
                .plateNumber(vehicle.getVehicleNumber())
                .vehicleColor(vehicle.getColour())
                .build();
    }

    @Override
    public PaymentResponse payment(PaymentRequest request) {
        return null;
    }

    @Override
    public UserFeedbackResponse feedback(UserFeedbackRequest request) {
        return null;
    }


//    @Override
//    public PaymentResponse payment(PaymentRequest request) {
//
//        return null;
//    }
//
//    @Override
//    public UserFeedbackResponse feedback(UserFeedbackRequest request) {
//        return null;
//    }
}
