package tn.Proxym.ProxymAcademy.dto;

import tn.Proxym.ProxymAcademy.validator.user.password.ValidPassword;
import tn.Proxym.ProxymAcademy.validator.user.username.ValidUsername;

public class UserSignInDto {

    @ValidUsername
    private String username ;
    @ValidPassword
    private String password ;

    public UserSignInDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
