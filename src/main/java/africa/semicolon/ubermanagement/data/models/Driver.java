package africa.semicolon.ubermanagement.data.models;
import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;
    private String driverName;
    private String address;

    @Email @Column(unique = true)
    public String email;
    private String driverContact;
    private String carNumber;
    private String carType;
    private String carColour;
    private String password;
    private Gender gender;



}
