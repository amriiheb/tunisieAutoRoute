package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="ressource")
public class Ressource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id ;

    @Column(name = "name")
     private String name ;

    @Column(name="description")
    private String description ;


    @Column(name="url")
    private String url ;

    @ManyToOne()
    @JoinColumn(name="id_chapter", referencedColumnName = "id")
    private Chapter chapter ;

    @Column(name = "type")
    private String type ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
