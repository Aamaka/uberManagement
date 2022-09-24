package africa.semicolon.ubermanagement.controllers;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.*;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.services.DriverService;
import africa.semicolon.ubermanagement.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/uber")
public class UserController {
    private  final UserServices services;
    private final DriverService driverService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) throws UserException {
        CreateUserResponse response = services.createUser(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("User created successfully")
                .data(response)
                .build();
        log.info("returning response");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest request) {
        LoginUserResponse response =  services.login(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("OK")
                .message("Where are you going to?")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @PostMapping("/book")
    public BookUserResponse book (@RequestBody BookUserRequest request) {
        log.info("login response controller");
        return services.book(request);
    }

    @PostMapping("/driver")
//    @RequestMapping(method = POST ,value = "")
    public ResponseEntity<?> register(@RequestBody RegisterDriverRequest request) throws UserException {
        log.info("Account creation Request ==> {}", request);
        RegisterDriverResponse response = driverService.register(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Driver created successfully")
                .data(response)
                .build();
        log.info("returning response");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getDriver")
    public DriverDto getDriver(@RequestBody String location) throws UserException {
        return driverService.getDriver(location);
    }

    @PostMapping("/login/driver")
    public ResponseEntity<?> loginDriver(@RequestBody LoginDriverRequest request) throws UserException {
        LoginDriverResponse response = driverService.login(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Start work")
                .data(response)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("vehicle/")
    public ResponseEntity<?> registerVehicle(@RequestBody RegisterVehicleRequest request) throws UserException{
        RegisterVehicleResponse response = driverService.registerVehicle(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Have a great first day with your vehicle")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

}
