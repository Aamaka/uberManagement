package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date = LocalDateTime.now();

    private String userAddress;

    @Email
    @Column(unique = true)

    private  String email;


    private String phoneNumber;

    private String pickUpAddress;

    private String dropOffAddress;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String confirmPassword;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Payment payment;

    private PaymentType paymentType;



//    public User(String name,  String email, String phoneNumber,String userAddress, String password, Gender gender) {
//        this.name = name;
//        this.userAddress = userAddress;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//        this.gender = gender;
//    }
}
