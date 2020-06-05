package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@NoArgsConstructor
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


}
