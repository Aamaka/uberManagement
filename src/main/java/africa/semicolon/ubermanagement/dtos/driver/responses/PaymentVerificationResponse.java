package africa.semicolon.ubermanagement.dtos.driver.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentVerificationResponse {
    private int id;
    private String domain;
    private String status;
    private String reference;
    private String amount;
    private String message;



}
