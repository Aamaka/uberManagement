package africa.semicolon.ubermanagement.data.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @NotBlank @NotNull
    private String vehicleType;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vehicleId;
}
