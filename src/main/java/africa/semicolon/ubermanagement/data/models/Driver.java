package africa.semicolon.ubermanagement.data.models;
import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String driverName;
    private String address;

    @Email
    @Column(unique = true)
    public String email;
    private String driverContact;
    private String carNumber;
    private String carType;
    private String carColour;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;

}
