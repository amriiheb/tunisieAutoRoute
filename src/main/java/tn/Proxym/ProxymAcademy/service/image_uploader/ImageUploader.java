package tn.Proxym.ProxymAcademy.service.image_uploader;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface ImageUploader {
    String ImageUpload(MultipartFile file, String uploadDirectory) ;
}
