package africa.semicolon.ubermanagement.controllers;

import africa.semicolon.ubermanagement.data.models.Trip;
import africa.semicolon.ubermanagement.dtos.driver.requests.GetTripHistory;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.ApiResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.LoginDriverResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.services.DriverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/driver/")
public class DriverController {


    private final DriverService driverService;

    @PostMapping("register/")
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

    @PostMapping("/login")
    public ResponseEntity<?> loginDriver(@RequestBody LoginDriverRequest request) throws UserException {
        LoginDriverResponse response = driverService.login(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Start work")
                .data(response)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Trip> getAllTrips(@RequestBody GetTripHistory history) throws UserException {
        return driverService.getAllTrips(history);
    }

}
