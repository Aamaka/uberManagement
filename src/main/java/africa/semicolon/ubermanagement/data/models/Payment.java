package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;
    private PaymentType paymentType;
    private Long amount;
}
