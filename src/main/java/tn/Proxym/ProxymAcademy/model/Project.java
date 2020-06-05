package tn.Proxym.ProxymAcademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="project")
@Getter
@Setter
@NoArgsConstructor
public class Project  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne()
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private User user;

    private String name ;

    private String client ;

    private int hours_spent;

    private int contribution ;

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }
}
