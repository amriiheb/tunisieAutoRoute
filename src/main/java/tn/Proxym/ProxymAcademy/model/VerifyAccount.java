package tn.Proxym.ProxymAcademy.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

@Entity
@Table(name = "verify_account")
public class VerifyAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(name = "token", columnDefinition = "text", unique = true)
	@Type(type = "org.hibernate.type.TextType")
	private String token;

	@Column
	private LocalDateTime expiredDataToken;

	@Column
	private LocalDateTime createdDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiredDataToken() {
		return expiredDataToken;
	}

	public void setExpiredDataToken(LocalDateTime expiredDataToken) {
		this.expiredDataToken = expiredDataToken;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getAccount() {
		return user;
	}

	public void setAccount(User account) {
		this.user = account;
	}

	public void setExpiredDataToken(int minutes) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		this.expiredDataToken = now.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(expiredDataToken);
	}

}
