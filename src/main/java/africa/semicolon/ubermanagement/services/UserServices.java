package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.dtos.user.requests.*;
import africa.semicolon.ubermanagement.dtos.user.responses.*;
import africa.semicolon.ubermanagement.exception.UserException;

import java.util.List;

public interface UserServices {
    CreateUserResponse createUser(CreateUserRequest request) throws UserException;
    LoginUserResponse login(LoginUserRequest request);
    BookUserResponse book(BookUserRequest request) throws UserException;

    List<Trip> getAllTrips(String email) throws UserException;
    InitialPaymentResponse payment(PaymentRequest request) throws UserException;
    UserFeedbackResponse feedback(UserFeedbackRequest request);
}
