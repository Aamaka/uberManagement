package africa.semicolon.ubermanagement.dtos.user.requests;

import africa.semicolon.ubermanagement.dtos.driver.requests.GetDriverRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserRequest {
    private String pickUpAddress;
    private String dropOffAddress;
   private String location;

    private String email;

}
