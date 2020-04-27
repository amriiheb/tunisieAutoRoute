package tn.Proxym.ProxymAcademy.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tn.Proxym.ProxymAcademy.audit.Auditable;
import tn.Proxym.ProxymAcademy.audit.SpringSecurityAuditorAware;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training")
@EntityListeners(SpringSecurityAuditorAware.class)
public class Training extends Auditable<String>  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name",length =100)
    private String name ;


    @Lob
    @Column(name = "description")
    private String description ;

    @Column(name = "difficulty")
    private String difficulty ;

    @Column
    private int numberofhours ;

 @Column
 private String photo ;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @ManyToOne()
    @JoinColumn(name="id_trainer", referencedColumnName = "id")
    private Trainer trainer;

   @ManyToMany(mappedBy="trainings")
   private Set<Learner> learners = new HashSet<>();

   @ManyToOne()
   @JoinColumn(name="id_category",referencedColumnName = "id")
   private TrainingCategory category ;

    @OneToMany(targetEntity=Module.class, mappedBy="training",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Module> Modules ;

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

    public Set<Learner> getLearners() {
        return learners;
    }

    public void setLearners(Set<Learner> learners) {
        this.learners = learners;
    }


    public Set<Module> getModules() {
        return Modules;
    }

    public void setModules(Set<Module> modules) {
        Modules = modules;
    }

    public TrainingCategory getCategorie() {
        return category;
    }

    public void setCategorie(TrainingCategory categorie) {
        this.category = categorie;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumberofhours() {
        return numberofhours;
    }

    public void setNumberofhours(int numberofhours) {
        this.numberofhours = numberofhours;
    }

    public TrainingCategory getCategory() {
        return category;
    }

    public void setCategory(TrainingCategory category) {
        this.category = category;
    }
}
