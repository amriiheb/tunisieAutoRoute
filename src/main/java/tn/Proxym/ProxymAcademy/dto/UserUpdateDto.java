package tn.Proxym.ProxymAcademy.dto;

import tn.Proxym.ProxymAcademy.validator.user.email.ValidEmail;
import tn.Proxym.ProxymAcademy.validator.user.password.ValidPassword;
import tn.Proxym.ProxymAcademy.validator.user.repeat_password.ValidRepeatPassword;
import tn.Proxym.ProxymAcademy.validator.user.update_email.ValidUpdateEmail;
import tn.Proxym.ProxymAcademy.validator.user.update_username.ValidUpdateUsername;
import tn.Proxym.ProxymAcademy.validator.user.username.ValidUsername;

@ValidRepeatPassword
@ValidUpdateEmail
@ValidUpdateUsername
public class UserUpdateDto {
    private Long id;

    @ValidUsername
    private String username;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
    private String repeatPassword;

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
        return "AccountUpdateDto [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
                + ", repeatPassword=" + repeatPassword + "]";
    }
}
