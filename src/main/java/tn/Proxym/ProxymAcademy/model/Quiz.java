package tn.Proxym.ProxymAcademy.model;

import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name="name")
    private String name ;

    @Column(name="goal")
    private String goal ;



    @OneToOne
    @JoinColumn(name="id_module", referencedColumnName = "id")
    private Module module ;

    @OneToMany(targetEntity=Question_Quiz.class, mappedBy="quiz",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question_Quiz> Questions ;

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

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Set<Question_Quiz> getQuestions() {
        return Questions;
    }

    public void setQuestions(Set<Question_Quiz> questions) {
        Questions = questions;
    }
}
