package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import africa.semicolon.ubermanagement.dtos.user.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.PaymentRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

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
        request.setPhoneNumber("670890354");
        request.setAddress("lag");
        request.setEmail("obik@gmail.com");
        request.setGender(Gender.MALE);
        request.setPassword("8888");
        request.setConfirmPassword("8888");
        CreateUserResponse response = services.createUser(request);
        assertNotNull(response);
        assertEquals("Your registration was successful Welcome Obi", response.getMessage());
    }

    @Test
    @DisplayName("Login user")
    public void  testThatAUserCanLogin()  {
        LoginUserRequest request = new LoginUserRequest();
        request.setEmail("obik@gmail.com");
        request.setPassword("8888");
        LoginUserResponse response = services.login(request);
        assertEquals("Welcome back Obi where you wan go?", response.getMessage());
    }

    @Test
    @DisplayName("Book a ride")
    public void aUserCanBookARideTest() throws UserException {
        BookUserRequest request = new BookUserRequest();
        request.setEmail("obik@gmail.com");
        request.setLocation("fadeyi");
        request.setPickUpAddress("juno");
        request.setDropOffAddress("aja");
        BookUserResponse response = services.book(request);

        assertEquals("lalah", response.getDriverName());
    }

    @Test
    @DisplayName("Test that a user can make payment")
    public void paymentTest() throws UserException {
        PaymentRequest request = PaymentRequest.builder()
                .email("obik@gmail.com")
                .paymentType(PaymentType.TRANSFER)
                .amount(BigInteger.valueOf(5000))
                .build();
        PaymentResponse response = services.payment(request);
        assertEquals("Your payment of $5000 for the trip from juno to aja was successful", response.getMessage());
    }
}
