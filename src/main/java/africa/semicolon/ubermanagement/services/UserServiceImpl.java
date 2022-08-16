package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.User;
import africa.semicolon.ubermanagement.data.repositories.UserRepository;
import africa.semicolon.ubermanagement.dtos.requests.*;
import africa.semicolon.ubermanagement.dtos.responses.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserServices{

    private  final UserRepository userRepository;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        User user = User.builder()
                .userAddress(request.getAddress())
                .userContactNumber(request.getPhoneNumber())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        User saved = userRepository.save(user);
        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("successful" + saved.getName());
        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        return null;
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
}
