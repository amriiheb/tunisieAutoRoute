package tn.Proxym.ProxymAcademy.dto.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import tn.Proxym.ProxymAcademy.validator.user.create_email.ValidCreateEmail;
import tn.Proxym.ProxymAcademy.validator.user.create_username.ValidCreateUsername;
import tn.Proxym.ProxymAcademy.validator.user.email.ValidEmail;
import tn.Proxym.ProxymAcademy.validator.user.password.ValidPassword;
import tn.Proxym.ProxymAcademy.validator.user.username.ValidUsername;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {
    private Long id ;
    private String username ;
    private String firstname ;
    private String lastname ;
    @ValidEmail
    @ValidCreateEmail
    private String email ;
    private String gender ;
    private String type ;
    @Override
    public String toString() {
        return "AccountCreateDto [id=" + id + ", username=" + username + ", email=" + email + "]";    }
}
