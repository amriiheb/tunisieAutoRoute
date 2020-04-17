package tn.Proxym.ProxymAcademy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "visitor")
public class Visitor extends User {



}
