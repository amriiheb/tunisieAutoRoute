package tn.Proxym.ProxymAcademy.dto.conference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class ConferenceDto {
    private Long id ;
    private String name ;
    private String  description ;
    private MultipartFile photo ;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
