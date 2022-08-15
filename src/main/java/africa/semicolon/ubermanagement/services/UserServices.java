package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.dtos.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.requests.UserFeedbackRequest;
import africa.semicolon.ubermanagement.dtos.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.dtos.responses.UserFeedbackResponse;

public interface UserServices {
    CreateUserResponse createUser(CreateUserRequest request);
    LoginUserResponse login(LoginUserRequest request);
    BookUserResponse book(BookUserRequest request);
    UserFeedbackResponse feedback(UserFeedbackRequest request);
}
