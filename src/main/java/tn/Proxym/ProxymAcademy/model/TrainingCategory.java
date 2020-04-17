package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Set;

@Entity
public class TrainingCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private String pathImage ;

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @OneToMany(targetEntity=Training.class, mappedBy="category",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Training> Trainings ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Training> getTrainings() {
        return Trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        Trainings = trainings;
    }
}
