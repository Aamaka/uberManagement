package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.User;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
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
    private final DriverRepository driverRepository;

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
    public LoginUserResponse login(LoginUserRequest request) {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            if(user.get().getPassword().equals(request.getPassword())){
                LoginUserResponse response = new LoginUserResponse();
                response.setMessage("Welcome back " + user.get().getName() + " where you wan go");
                return response;
            }
        }
        throw  new NullPointerException("User does not exist");
    }

    @Override
    public BookUserResponse book(BookUserRequest request) {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            user.get().setPickUpAddress(request.getPickUpAddress());
            user.get().setDropOffAddress(request.getDropOffAddress());
            BookUserResponse response = new BookUserResponse();
            response.setMessage("your trip from " + user.get().getPickUpAddress() + " to "
            + user.get().getDropOffAddress());
            return response;
        }else {
            return null;
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
