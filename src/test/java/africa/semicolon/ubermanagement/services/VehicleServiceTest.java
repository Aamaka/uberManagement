package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterVehicleResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Test
    @DisplayName("Register a vehicle")
    public void testThatADriverCanRegisterAVehicle() throws UserException {
        RegisterVehicleRequest request = RegisterVehicleRequest.builder()
                .email("lalah@gmail.com")
                .vehicleNumber("58794TU8")
                .model("Benz")
                .colour("grey")
                .build();
        RegisterVehicleResponse response = vehicleService.registerVehicle(request);
        assertNotNull(response);
        assertEquals("Vehicle assigned successfully to lalah", response.getMessage());
    }
}