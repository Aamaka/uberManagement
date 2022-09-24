package africa.semicolon.ubermanagement.dtos.driver.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVehicleRequest {
    @Email
    private String email;

    private String model;

    @Column(unique = true)
    private String vehicleNumber;

    private String colour;
}
