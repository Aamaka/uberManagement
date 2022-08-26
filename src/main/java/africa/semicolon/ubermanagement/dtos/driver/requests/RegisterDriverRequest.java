package africa.semicolon.ubermanagement.dtos.driver.requests;
import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDriverRequest {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String carNumber;
    private String carType;
    private String carColour;
    private Gender gender;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String confirmPassword;

    private String location;
}
