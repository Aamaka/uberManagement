package africa.semicolon.ubermanagement.services;

import africa.semicolon.ubermanagement.data.models.Driver;
import africa.semicolon.ubermanagement.dtos.driver.requests.GetDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterVehicleRequest;
import africa.semicolon.ubermanagement.dtos.driver.responses.*;
import africa.semicolon.ubermanagement.dtos.driver.requests.LoginDriverRequest;
import africa.semicolon.ubermanagement.dtos.driver.requests.RegisterDriverRequest;
import africa.semicolon.ubermanagement.dtos.user.requests.PaymentRequest;
import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import africa.semicolon.ubermanagement.exception.UserException;

public interface DriverService {
    RegisterDriverResponse register(RegisterDriverRequest request) throws UserException;

    Driver getDriver(String location) throws UserException;
    LoginDriverResponse login(LoginDriverRequest request) throws UserException;


    BookingResponse bookingDetails(String location);

    PaymentResponse payment(PaymentRequest request);


}
