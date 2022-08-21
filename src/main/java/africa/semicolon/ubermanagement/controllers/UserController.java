package africa.semicolon.ubermanagement.controllers;

import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.ApiResponse;
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
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws UserException {
        return services.createUser(request);
    }

    @GetMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request){
        return services.login(request);
    }

    @PostMapping("/book")
    public BookUserResponse book (@RequestBody BookUserRequest request){
        return services.book(request);
    }

    @PostMapping("/driver")
    public ResponseEntity<?> register(@RequestBody RegisterDriverRequest request){
        log.info("Account creation Request ==> {}", request);
        driverService.register(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Driver created successfully")
                .data(request)
                .build();
        log.info("returning response");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
