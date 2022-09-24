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
    public BookUserResponse book(BookUserRequest request) {
        return null;
    }

    @Override
    public PaymentResponse payment(PaymentRequest request) {
        return null;
    }

    @Override
    public UserFeedbackResponse feedback(UserFeedbackRequest request) {
        return null;
    }

//
//    @Override
//    public BookUserResponse book(BookUserRequest request) throws UserException {
//        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
//        if(user.isPresent()){
//            user.get().setPickUpAddress(request.getPickUpAddress());
//            user.get().setDropOffAddress(request.getDropOffAddress());
//            BookUserResponse response = new BookUserResponse();
//            response.setMessage("you have been connected to " + driverService.getDriver(request.getLocation())
//                    + " your trip from " + user.get().getPickUpAddress() + " has been ordered.");
//            response.setDateTime(response.getDateTime());
//            return response;
//        }else {
//            throw new UserException("Invalid email", HttpStatus.NOT_FOUND);
//        }
//
//    }
//
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
