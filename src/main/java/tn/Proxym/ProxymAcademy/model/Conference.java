package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.Proxym.ProxymAcademy.audit.Auditable;
import tn.Proxym.ProxymAcademy.audit.SpringSecurityAuditorAware;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conference")
@EntityListeners(SpringSecurityAuditorAware.class)
@Getter
@Setter
@NoArgsConstructor
public class Conference extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name",length =100)
    private String name ;

    @Column
    private String Description ;
    @Column
    private String photo ;
}
