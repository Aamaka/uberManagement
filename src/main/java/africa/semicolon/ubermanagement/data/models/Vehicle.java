package africa.semicolon.ubermanagement.data.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String model;

    @Column(unique = true)
    private String vehicleNumber;

    private String colour;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;

}
