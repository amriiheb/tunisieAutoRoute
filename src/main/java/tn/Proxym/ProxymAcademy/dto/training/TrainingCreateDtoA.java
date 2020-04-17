package tn.Proxym.ProxymAcademy.dto.training;

import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;

public class TrainingCreateDtoA {
    private Long id ;
    private String name ;
    private String description ;
    private Trainer trainer ;
    private TrainingCategory Category ;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingCategory getCategory() {
        return Category;
    }

    public void setCategory(TrainingCategory category) {
        Category = category;
    }
}
