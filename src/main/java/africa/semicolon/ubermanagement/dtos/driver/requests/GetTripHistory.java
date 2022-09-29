package africa.semicolon.ubermanagement.dtos.driver.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTripHistory {
    private String email;
}
