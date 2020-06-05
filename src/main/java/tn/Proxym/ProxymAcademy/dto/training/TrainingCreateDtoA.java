package tn.Proxym.ProxymAcademy.dto.training;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
@Getter
@Setter
@NoArgsConstructor
public class TrainingCreateDtoA {
    private Long id ;
    private String name ;
    private String description ;
    private Trainer trainer ;
    private TrainingCategory Category ;
    private String Difficulty ;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    private int NumberOfHours ;
    private MultipartFile photo ;



}
