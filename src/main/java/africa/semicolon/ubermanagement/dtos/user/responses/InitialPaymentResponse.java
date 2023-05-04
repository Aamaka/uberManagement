package africa.semicolon.ubermanagement.dtos.user.responses;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InitialPaymentResponse {
    private boolean status;
    private String message;
    private PaymentResponse data;
}
