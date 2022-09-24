//package africa.semicolon.ubermanagement.services;
//import africa.semicolon.ubermanagement.dtos.driver.responses.DriverDto;
//import africa.semicolon.ubermanagement.data.models.enums.Gender;
//import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
//import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
//import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
//import africa.semicolon.ubermanagement.exception.UserException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class DriverServiceTest {
//
//    @Autowired
//    private DriverService driverService;
//
//    @Test
//    @DisplayName("Create a user")
//    public void testToCreateAUser() throws UserException {
//        RegisterDriverRequest request = RegisterDriverRequest.builder()
//                .name("lalah")
//                .address("aja")
//                .carColour("pink")
//                .carNumber("6789064537")
//                .carType("Benz")
//                .location("aja")
//                .email("lalah@gmail.com")
//                .phoneNumber("56778909876")
//                .gender(Gender.MALE)
//                .password("9876")
//                .confirmPassword("9876")
//                .build();
//        RegisterDriverResponse response = driverService.register(request);
//        assertNotNull(response);
//        assertEquals("lalah Your registration was successful", response.getMessage());
//    }
//
//    @Test
//    @DisplayName("login a user")
//    public void testToLoginAUser() throws UserException {
//        LoginDriverRequest request = new LoginDriverRequest();
//        request.setEmail("lag@gmail.com");
//        request.setLocation("fadeyi");
//        request.setPassword("9876");
//        DriverDto response = driverService.login(request);
//        assertEquals("Welcome back, Aye", response.getMessage());
//    }
//
//    @Test
//    @DisplayName("get a driver")
//    public void testToGetADriver() throws UserException {
//        DriverDto driverDto = driverService.getDriver("aja");
//        assertEquals("Peter", driverDto.getName());
//
//    }
//}