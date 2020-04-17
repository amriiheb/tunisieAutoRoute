package tn.Proxym.ProxymAcademy.model;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Admin extends  Learner{

}
