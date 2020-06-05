package tn.Proxym.ProxymAcademy.dto.trainingCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Getter
@Setter
@NoArgsConstructor
public class TrainingCategoryDto {
    private long id ;
    private String name ;
    private String description ;
    private MultipartFile photo ;


}
