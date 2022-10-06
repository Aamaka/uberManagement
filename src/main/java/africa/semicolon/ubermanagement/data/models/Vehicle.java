package africa.semicolon.ubermanagement.data.models;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String model;

    @Column(unique = true)
    private String vehicleNumber;

    private String colour;

    @JoinColumn
    @OneToOne
    private Driver driver;

}
