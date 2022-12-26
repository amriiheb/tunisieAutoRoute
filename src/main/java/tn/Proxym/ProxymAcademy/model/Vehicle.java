package tn.Proxym.ProxymAcademy.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle implements Serializable {
    private static final long serialVersionUID = -2460659701384032012L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private String plateNumber;
    private String plateType;
    private String name;
    @Lob
    private String plateImage;
    @Lob
    private String vehicleImage;
}
