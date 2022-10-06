package africa.semicolon.ubermanagement.dtos.user.requests;

import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@Builder
public class PaymentRequest {
    private String email;
    private PaymentType paymentType;
    private BigInteger amount;
    
}
