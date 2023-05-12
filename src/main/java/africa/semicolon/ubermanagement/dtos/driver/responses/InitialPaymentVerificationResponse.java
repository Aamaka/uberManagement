package africa.semicolon.ubermanagement.dtos.driver.responses;

import africa.semicolon.ubermanagement.dtos.user.responses.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InitialPaymentVerificationResponse {
    private boolean status;
    private String message;
    private PaymentVerificationResponse data;
}
