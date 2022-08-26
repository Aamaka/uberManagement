package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.dtos.user.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices services;

    @Test
    @DisplayName("Add a user")
    public void addAUserTest() throws UserException {
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Obi");
        request.setPhoneNumber("67890354");
        request.setAddress("lag");
        request.setEmail("obi@gmail.com");
        request.setGender(Gender.MALE);
        request.setPassword("8888");
        request.setConfirmPassword("8888");
        CreateUserResponse response = services.createUser(request);
        assertNotNull(response);
        assertEquals("successful Obi", response.getMessage());
    }

    @Test
    @DisplayName("Login user")
    public void  testThatAUserCanLogin() throws UserException {
        LoginUserRequest request = new LoginUserRequest();
        request.setEmail("obi@gmail.com");
        request.setPassword("8888");
        LoginUserResponse response = services.login(request);
        assertEquals("Welcome back Obi where you wan go", response.getMessage());
    }

    @Test
    @DisplayName("Book a ride")
    public void aUserCanBookARideTest() throws UserException {
        BookUserRequest request = new BookUserRequest();
        request.setEmail("obi@gmail.com");
        request.setLocation("Juno");
        request.setPickUpAddress("fadeyi");
        request.setDropOffAddress("aja");
        BookUserResponse response = services.book(request);

        assertEquals("you have been connected to name='John'," +
                " phoneNumber='34567899', model='kiowope', vehicleNumber='2345uy'," +
                " color='null' your trip from fadeyi has been ordered.", response.getMessage());
    }
}