package africa.semicolon.ubermanagement.controllers;

import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.dtos.driver.requests.GetTripHistory;
import africa.semicolon.ubermanagement.dtos.driver.responses.ApiResponse;
import africa.semicolon.ubermanagement.dtos.user.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.PaymentRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user/")
public class UserController {
    private  final UserServices services;


    @PostMapping("register/")
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
    public BookUserResponse book (@RequestBody BookUserRequest request) throws UserException {
        log.info("login response controller");
        return services.book(request);
    }

    @GetMapping("/allTrips/{email}")
    public List<Trip> getAllTrips(@PathVariable String email) throws UserException {
        return services.getAllTrips(email);
    }

    @PostMapping("/payment")
    public PaymentResponse payment(@RequestBody PaymentRequest request) throws UserException{
        return services.payment(request);
    }

}
