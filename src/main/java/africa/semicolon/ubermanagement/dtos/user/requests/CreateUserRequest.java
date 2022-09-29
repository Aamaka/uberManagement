package africa.semicolon.ubermanagement.dtos.user.requests;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.*;


import javax.persistence.Column;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;
    private String address;
    private Gender gender;

    private String password;


    private String confirmPassword;

}
