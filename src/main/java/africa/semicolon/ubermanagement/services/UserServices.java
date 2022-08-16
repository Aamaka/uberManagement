package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.dtos.requests.*;
import africa.semicolon.ubermanagement.dtos.responses.*;

public interface UserServices {
    CreateUserResponse createUser(CreateUserRequest request);
    LoginUserResponse login(LoginUserRequest request);
    BookUserResponse book(BookUserRequest request);
    PaymentResponse payment(PaymentRequest request);
    UserFeedbackResponse feedback(UserFeedbackRequest request);
}
