package tn.Proxym.ProxymAcademy.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.validator.user.create_email.ValidCreateEmail;
import tn.Proxym.ProxymAcademy.validator.user.email.ValidEmail;
@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDto {
    private Long id;
    private String firstname;
    private String lastname;
    private MultipartFile photo ;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}



