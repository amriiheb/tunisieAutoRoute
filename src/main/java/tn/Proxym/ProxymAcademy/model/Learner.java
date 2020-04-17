package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="learner")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Learner extends User implements Serializable {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "learner_training", joinColumns = {
            @JoinColumn(name = "learner_id") }, inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<Training> trainings=new HashSet<>();


    public Learner() {
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }



}
