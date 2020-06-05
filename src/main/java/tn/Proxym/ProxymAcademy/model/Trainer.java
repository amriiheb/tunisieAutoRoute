package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trainer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Trainer  extends Learner{

    @OneToMany(targetEntity=Training.class, mappedBy="trainer",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
     private Set<Training> Trainings ;

    @Override
    public Set<Training> getTrainings() {
        return Trainings;
    }

    @Override
    public void setTrainings(Set<Training> trainings) {
        Trainings = trainings;
    }
}
