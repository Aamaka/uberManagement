package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.dtos.user.requests.*;
import africa.semicolon.ubermanagement.dtos.user.responses.*;
import africa.semicolon.ubermanagement.exception.UserException;

public interface UserServices {
    CreateUserResponse createUser(CreateUserRequest request) throws UserException;
    LoginUserResponse login(LoginUserRequest request) throws UserException;
    BookUserResponse book(BookUserRequest request) throws UserException;
    PaymentResponse payment(PaymentRequest request);
    UserFeedbackResponse feedback(UserFeedbackRequest request);
}
