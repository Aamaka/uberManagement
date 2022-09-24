package africa.semicolon.ubermanagement.data.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String location;

    private String pickUpAddress;

    private String dropOffAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time = LocalDateTime.now();
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Driver driver;



}
