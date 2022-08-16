package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "name")
    private String name;

    private String userAddress;

    @Email
    private  String email;

    private String userContactNumber;

    private String phoneNumber;

    private String pickUpAddress;

    private String dropOffAddress;

    private String password;

    private Gender gender;

    @ManyToOne
    private Payment payment;

    private PaymentType paymentType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date = LocalDateTime.now();
}
