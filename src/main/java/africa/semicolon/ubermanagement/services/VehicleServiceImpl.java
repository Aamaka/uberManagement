package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.Vehicle;
import africa.semicolon.ubermanagement.data.repositories.DriverRepository;
import africa.semicolon.ubermanagement.data.repositories.VehicleRepository;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterVehicleResponse;
import africa.semicolon.ubermanagement.exception.UserException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final DriverRepository repository;

    @Override
    public Vehicle getVehicleByDriver(Driver driver) {
        return vehicleRepository.findByDriver(driver)
                .orElseThrow(()->new RuntimeException("vehicle not found"));
    }

    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) throws UserException {

        Optional<Driver> driver = repository.findDriverByEmail(request.getEmail());
        if(driver.isPresent()){
            Optional<Vehicle> vehicle = vehicleRepository.findByDriver(driver.get());
            if(vehicle.isEmpty()){
                Vehicle vehicle1 = Vehicle.builder()
                        .model(request.getModel())
                        .vehicleNumber(request.getVehicleNumber())
                        .colour(request.getColour())
                        .driver(driver.get())
                        .build();
                Vehicle saved = vehicleRepository.save(vehicle1);
                RegisterVehicleResponse response = new RegisterVehicleResponse();
                response.setMessage("Vehicle assigned successfully to "+ saved.getDriver().getName());
                return response;
            }
            throw new UserException("You already have a vehicle", HttpStatus.NOT_ACCEPTABLE);
        }
        throw new UserException("Driver does not exist", HttpStatus.FOUND);
    }
}
