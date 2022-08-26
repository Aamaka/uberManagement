package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.DriverDto;
import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    @Test
    @DisplayName("Create a user")
    public void testToCreateAUser() throws UserException {
        RegisterDriverRequest request = RegisterDriverRequest.builder()
                .name("Aye")
                .address("lasu")
                .carColour("pink")
                .carNumber("678906453")
                .carType("Benz")
                .email("lag@gmail.com")
                .phoneNumber("5678909876")
                .gender(Gender.MALE)
                .password("9876")
                .confirmPassword("9876")
                .build();
        RegisterDriverResponse response = driverService.register(request);
        assertNotNull(response);
        assertEquals("Aye Your registration was successful", response.getMessage());
    }

    @Test
    @DisplayName("login a user")
    public void testToLoginAUser() throws UserException {
        LoginDriverRequest request = new LoginDriverRequest();
        request.setEmail("lag@gmail.com");
        request.setLocation("fadeyi");
        request.setPassword("9876");
        DriverDto response = driverService.login(request);
        assertEquals("Welcome back, Aye", response.getMessage());
    }

    @Test
    @DisplayName("get a driver")
    public void testToGetADriver() throws UserException {
        DriverDto driverDto = driverService.getDriver("fadeyi");
        assertEquals("Aye", driverDto.getName());
        assertEquals("5678909876", driverDto.getPhoneNumber());
    }
}