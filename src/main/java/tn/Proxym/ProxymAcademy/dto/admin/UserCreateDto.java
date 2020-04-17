package tn.Proxym.ProxymAcademy.dto.admin;

import tn.Proxym.ProxymAcademy.validator.user.create_email.ValidCreateEmail;
import tn.Proxym.ProxymAcademy.validator.user.create_username.ValidCreateUsername;
import tn.Proxym.ProxymAcademy.validator.user.email.ValidEmail;
import tn.Proxym.ProxymAcademy.validator.user.password.ValidPassword;
import tn.Proxym.ProxymAcademy.validator.user.username.ValidUsername;

public class UserCreateDto {
    private Long id ;
    @ValidUsername
    @ValidCreateUsername
    private String username ;

    @ValidEmail
    @ValidCreateEmail
    private String email ;

    private String gender ;

    private String type ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountCreateDto [id=" + id + ", username=" + username + ", email=" + email + "]";    }
}
