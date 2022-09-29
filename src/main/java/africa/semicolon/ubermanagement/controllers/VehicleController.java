package africa.semicolon.ubermanagement.controllers;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.ApiResponse;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterVehicleResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import africa.semicolon.ubermanagement.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vehicle/")
public class VehicleController {
    private final VehicleService vehicleService;


    @PostMapping("register/")
    public ResponseEntity<?> registerVehicle(@RequestBody RegisterVehicleRequest request) throws UserException {
        RegisterVehicleResponse response = vehicleService.registerVehicle(request);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("Successful")
                .message("Have a great first day with your vehicle")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

}
