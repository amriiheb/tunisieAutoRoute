package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="skills")
@Getter
@Setter
@NoArgsConstructor
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne()
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private User user;
    private String name ;
    private int level ;


}
