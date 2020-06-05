package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name="id_module", referencedColumnName = "id")
    private Module module ;

    @Column(name = "type")
    private String type ;


}
