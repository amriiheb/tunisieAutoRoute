package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "chapter")
public class Chapter implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;

@Column(name = "name")
private String name  ;

@Column(name = "description")
private String description ;

@Column(name="number")
private int number ;

@ManyToOne()
@JoinColumn(name="id_Module", referencedColumnName = "id")
private Module module ;

@OneToMany(targetEntity=Ressource.class, mappedBy="chapter",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ressource> ressources ;

@Column(name = "contained")
private String contained ;

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Set<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(Set<Ressource> ressources) {
        this.ressources = ressources;
    }

    public String getContained() {
        return contained;
    }

    public void setContained(String contained) {
        this.contained = contained;
    }

    public Chapter() {
    }
}
