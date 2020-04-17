package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable{

	private static final long serialVersionUID = 8374992679263373931L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", unique=true, length=100)
	private String name;
	
	@Lob
	@Column(name="description")
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
