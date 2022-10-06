package africa.semicolon.ubermanagement.data.models;

import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private Gender gender;




}
