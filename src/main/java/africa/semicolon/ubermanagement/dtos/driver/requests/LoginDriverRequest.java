package africa.semicolon.ubermanagement.dtos.driver.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDriverRequest {
    private String email;
    private String location;
    private String password;

}
