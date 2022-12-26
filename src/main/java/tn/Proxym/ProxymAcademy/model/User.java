package tn.Proxym.ProxymAcademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.audit.Auditable;
import tn.Proxym.ProxymAcademy.audit.SpringSecurityAuditorAware;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(SpringSecurityAuditorAware.class)
@Getter
@Setter
@NoArgsConstructor
public   class User implements Serializable{

	private static final long serialVersionUID = -2460659701384032012L;


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(insertable = false, updatable = false)
	private String dtype;


	@Column(name = "USERNAME", length = 100, unique = true)
	private String username;

	@Column(name = "EMAIL", length = 100, unique = true)
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "active")
	private boolean active;

	@Column(name="firstname")
	private String firstname ;

	@Column(name="lastname")
	private String lastname ;
	@Column(name="birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday ;

	@Column(name = "photo")
	private String photoUrl ;

    @Column(name = "gender")
	private String Gender ;

    @Column(name = "cv")
	private String cv ;

    @Column(name = "location")
	private String location ;

    @Column(name="job")
	private String job ;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<VerifyAccount> verifyAccounts;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<VerifyAccount> getVerifyAccounts() {
		return verifyAccounts;
	}

	public void setVerifyAccounts(Set<VerifyAccount> verifyAccounts) {
		this.verifyAccounts = verifyAccounts;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> addRole(Role role) {
		if(roles == null) {
			roles = new HashSet<Role>();
		}
		roles.add(role);
		return roles;
	}
}
