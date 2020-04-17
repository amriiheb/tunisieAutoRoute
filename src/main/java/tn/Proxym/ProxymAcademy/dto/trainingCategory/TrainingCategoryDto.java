package tn.Proxym.ProxymAcademy.dto.trainingCategory;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class TrainingCategoryDto {

    private long id ;
    private String name ;
    private MultipartFile photo ;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
