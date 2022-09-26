package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Vehicle;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterVehicleResponse;
import africa.semicolon.ubermanagement.exception.UserException;

import java.util.Optional;

public interface VehicleService {
    Vehicle getVehicleByDriver(Driver driver);

    RegisterVehicleResponse registerVehicle (RegisterVehicleRequest request) throws UserException;
}
