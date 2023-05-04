package africa.semicolon.ubermanagement.data.models;
import africa.semicolon.ubermanagement.data.models.enums.Gender;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


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

    @Column(unique = true)
    private  String email;

    @Column(unique = true)
    private String phoneNumber;

    private String password;

    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private Gender gender;




}
