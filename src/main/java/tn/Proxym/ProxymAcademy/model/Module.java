package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "module")
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String Description ;

    @Column(name = "number")
    private int number ;

    @ManyToOne()
    @JoinColumn(name="id_training", referencedColumnName = "id")
    private Training training ;

    @OneToMany(targetEntity=Chapter.class, mappedBy="module",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Chapter> Chapter ;



    @OneToOne
    private Quiz quiz ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Set<tn.Proxym.ProxymAcademy.model.Chapter> getChapter() {
        return Chapter;
    }

    public void setChapter(Set<tn.Proxym.ProxymAcademy.model.Chapter> chapter) {
        Chapter = chapter;
    }
}
