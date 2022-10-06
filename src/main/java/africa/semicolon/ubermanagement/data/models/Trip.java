package africa.semicolon.ubermanagement.data.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String location;

    private String pickUpAddress;

    private String dropOffAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Driver driver;

}
