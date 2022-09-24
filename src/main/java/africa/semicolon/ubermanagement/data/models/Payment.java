package africa.semicolon.ubermanagement.data.models;
import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private BigInteger amount;

    @OneToOne
    @JoinColumn
    private Trip trip;

    @ManyToOne
    @JoinColumn
    private User user;
}
