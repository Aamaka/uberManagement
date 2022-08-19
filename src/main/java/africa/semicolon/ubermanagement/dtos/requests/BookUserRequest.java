package africa.semicolon.ubermanagement.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserRequest {
    private String pickUpAddress;
    private String dropOffAddress;
    private String email;
}
