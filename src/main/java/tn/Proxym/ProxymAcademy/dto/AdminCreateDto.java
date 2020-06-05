package tn.Proxym.ProxymAcademy.dto;

import tn.Proxym.ProxymAcademy.validator.user.create_email.ValidCreateEmail;
import tn.Proxym.ProxymAcademy.validator.user.create_username.ValidCreateUsername;
import tn.Proxym.ProxymAcademy.validator.user.email.ValidEmail;
import tn.Proxym.ProxymAcademy.validator.user.password.ValidPassword;
import tn.Proxym.ProxymAcademy.validator.user.repeat_password.ValidRepeatPassword;
import tn.Proxym.ProxymAcademy.validator.user.username.ValidUsername;
@ValidRepeatPassword
public class AdminCreateDto {
    private Long id ;
    @ValidUsername
    @ValidCreateUsername
    private String username ;

    @ValidEmail
    @ValidCreateEmail
    private String email ;
    @ValidPassword
    private String password ;

    private String repeatPassword ;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Override
    public String toString() {
        return "AccountCreateDto [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
                + ", repeatPassword=" + repeatPassword + "]";    }
}
