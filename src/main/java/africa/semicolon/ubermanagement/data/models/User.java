package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import africa.semicolon.ubermanagement.data.models.enums.PaymentType;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String address;

    @Email
    @Column(unique = true)
    private  String email;

    @Column(unique = true)
    private String phoneNumber;

//    @JsonIgnore
    private String password;

//    @JsonIgnore
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private Gender gender;




}
