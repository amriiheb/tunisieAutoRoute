package tn.Proxym.ProxymAcademy.service.image_uploader.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;
import tn.Proxym.ProxymAcademy.util.category.RandomName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageUploaderImpl implements ImageUploader {

    @Autowired
    RandomName randomName ;
    @Override
    public String ImageUpload(MultipartFile file, String uploadDirectory) {
        StringBuilder fileNames = new StringBuilder();
        String NameFileSave=randomName.generateRandomString()+file.getOriginalFilename() ;
        Path fileNameAndPath = Paths.get(uploadDirectory,NameFileSave);

        fileNames.append(file.getOriginalFilename()+" ");
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
         return NameFileSave;

    }
}
