package tn.Proxym.ProxymAcademy.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.Proxym.ProxymAcademy.audit.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class TrainingCategory  extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private String Description ;
    private String pathImage ;
    @OneToMany(targetEntity=Training.class, mappedBy="category",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Training> Trainings ;
}
