package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;
    private String driverName;
    private String address;

    @Valid @Email
    public String email;
    private String driverContact;
    private String carNumber;
    private String carType;
    private String carColour;
    private String password;
    private Gender gender;



}
