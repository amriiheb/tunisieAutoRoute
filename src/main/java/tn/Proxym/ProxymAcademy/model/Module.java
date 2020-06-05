package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.Proxym.ProxymAcademy.audit.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "module")
@Getter
@Setter
@NoArgsConstructor
public class Module extends Auditable<String>  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String Description ;

    @Column(name = "number")
    private int number ;

    @ManyToOne()
    @JoinColumn(name="id_training", referencedColumnName = "id")
    private Training training ;


   /* @OneToMany(targetEntity=Ressource.class, mappedBy="module",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ressource> ressources ;*/

    @Column(name = "contained")
    @Lob
    private String contained ;

    @OneToOne
    private Quiz quiz ;
}
