package africa.semicolon.ubermanagement.mapper;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.data.models.DriverDto;
import africa.semicolon.ubermanagement.dtos.driver.responses.RegisterDriverResponse;

public class Mapper {
    public static void map(Driver saved, RegisterDriverResponse response) {
        response.setMessage(saved.getDriverName() + " Your registration was successful");
        response.setName(saved.getDriverName());
        response.setPhoneNumber(saved.getDriverContact());
        response.setModel(saved.getCarType());
        response.setVehicleNumber(saved.getCarNumber());
        response.setCarColour(saved.getCarColour());
    }

    public static void mapper(Driver driver1, DriverDto driverDto) {
        driverDto.setName(driver1.getDriverName());
        driverDto.setModel(driver1.getCarType());
        driverDto.setColor(driver1.getCarColour());
        driverDto.setPhoneNumber(driver1.getDriverContact());
        driverDto.setVehicleNumber(driver1.getCarNumber());
    }
}
