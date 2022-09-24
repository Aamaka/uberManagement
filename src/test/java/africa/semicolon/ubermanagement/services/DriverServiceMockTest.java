//package africa.semicolon.ubermanagement.services;
//import africa.semicolon.ubermanagement.data.models.Driver;
//import africa.semicolon.ubermanagement.dtos.driver.responses.DriverDto;
//import africa.semicolon.ubermanagement.data.models.enums.Gender;
//import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
//import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
//import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
//import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
//import africa.semicolon.ubermanagement.exception.UserException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class DriverServiceMockTest {
//    private DriverService driverService;
//    @Mock
//    private DriverRepository driverRepository;
//
//    @BeforeEach
//    void setUp() {
//        driverService = new DriverServiceImpl(driverRepository);
//    }
//
//    @Test
//    public void testThatADriverCanBeCreated() throws UserException {
//        RegisterDriverRequest registerDriverRequest = RegisterDriverRequest.builder()
//                .name("Sholah")
//                .address("lagos")
//                .carColour("pink")
//                .carNumber("548906453")
//                .carType("Benz")
//                .email("sholah@gmail.com")
//                .phoneNumber("5678909876")
//                .gender(Gender.MALE)
//                .password("9999")
//                .confirmPassword("9999")
//                .location("yaba")
//                .build();
//        Driver driver = Driver.builder().driverName("Sholah")
//                .address("lagos")
//                .carColour("pink")
//                .carNumber("548906453")
//                .carType("Benz")
//                .email("sholah@gmail.com")
//                .driverContact("5678909876")
//                .gender(Gender.MALE)
//                .password("9999")
//                .confirmPassword("9999")
//                .location("yaba")
//                .build();
//        when(driverRepository.save(any(Driver.class))).thenReturn(driver);
//        RegisterDriverResponse response = driverService.register(registerDriverRequest);
//        verify(driverRepository, times(1)).save(any(Driver.class));
//        assertThat(response.getName()).isEqualTo("Sholah");
//    }
//
//    @Test
//    public void testThatADriverCanLogIn() throws UserException {
//        RegisterDriverRequest registerDriverRequest = RegisterDriverRequest.builder()
//                .name("Sholah")
//                .address("lagos")
//                .carColour("pink")
//                .carNumber("548906453")
//                .carType("Benz")
//                .email("sholah@gmail.com")
//                .phoneNumber("5678909876")
//                .gender(Gender.MALE)
//                .password("9999")
//                .confirmPassword("9999")
//                .location("yaba")
//                .build();
//        Driver driver = Driver.builder().driverName("Sholah")
//                .address("lagos")
//                .carColour("pink")
//                .carNumber("548906453")
//                .carType("Benz")
//                .email("sholah@gmail.com")
//                .driverContact("5678909876")
//                .gender(Gender.MALE)
//                .password("9999")
//                .confirmPassword("9999")
//                .location("yaba")
//                .build();
//        when(driverRepository.save(any(Driver.class))).thenReturn(driver);
//        RegisterDriverResponse response = driverService.register(registerDriverRequest);
//        verify(driverRepository, times(1)).save(any(Driver.class));
//        assertThat(response.getName()).isEqualTo("Sholah");
//        LoginDriverRequest loginDriverRequest = new LoginDriverRequest();
//        loginDriverRequest.setLocation("sabo");
//        loginDriverRequest.setEmail("sholah@gmail.com");
//        loginDriverRequest.setPassword("9999");
//
//        Driver driver1 = Driver.builder()
//                .email("sholah@gmail.com")
//                .password("9999")
//                .location("sabo")
//                .build();
//
//        when(driverRepository.findByEmail(loginDriverRequest.getEmail())).thenReturn(Optional.ofNullable(driver1));
//        DriverDto driverDto = driverService.login(loginDriverRequest);
//        verify(driverRepository, times(1)).save(driver);
//        assertThat(driverDto.getName()).isEqualTo("Sholah");
//
//    }
//
//}
