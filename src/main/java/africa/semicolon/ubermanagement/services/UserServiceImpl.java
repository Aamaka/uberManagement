package africa.semicolon.ubermanagement.services;
import africa.semicolon.ubermanagement.data.models.User;
import africa.semicolon.ubermanagement.data.repositories.UserRepository;
import africa.semicolon.ubermanagement.dtos.user.requests.*;
import africa.semicolon.ubermanagement.dtos.user.responses.*;
import africa.semicolon.ubermanagement.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserServices{

    private  final UserRepository userRepository;
    private final DriverService driverService;


    @Override
    public CreateUserResponse createUser(CreateUserRequest request) throws UserException {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .userAddress(request.getAddress())
                .gender(request.getGender())
                .password(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .build();
        if(request.getPassword().equals(request.getConfirmPassword())){
            User saved = userRepository.save(user);
            CreateUserResponse response = new CreateUserResponse();
            response.setMessage("successful " + saved.getName());
            return response;
        }else {
            throw new UserException("Password does not match", HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) throws UserException {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            if(user.get().getPassword().equals(request.getPassword())){
                LoginUserResponse response = new LoginUserResponse();
                log.info("login response");
                response.setMessage("Welcome back " + user.get().getName() + " where you wan go");
                return response;
            }else {
                throw  new UserException("Invalid details", HttpStatus.NOT_FOUND);
            }
        }
        throw  new UserException("User does not exist", HttpStatus.NOT_FOUND);
    }

    @Override
    public BookUserResponse book(BookUserRequest request) throws UserException {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            user.get().setPickUpAddress(request.getPickUpAddress());
            user.get().setDropOffAddress(request.getDropOffAddress());
            BookUserResponse response = new BookUserResponse();
            response.setMessage("you have been connected to " + driverService.getDriver(request.getLocation())
                    + " your trip from " + user.get().getPickUpAddress() + " has been ordered.");
            response.setDateTime(response.getDateTime());
            return response;
        }else {
            throw new UserException("Invalid email", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public PaymentResponse payment(PaymentRequest request) {
        return null;
    }

    @Override
    public UserFeedbackResponse feedback(UserFeedbackRequest request) {
        return null;
    }
}
