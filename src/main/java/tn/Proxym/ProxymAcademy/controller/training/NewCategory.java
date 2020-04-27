package tn.Proxym.ProxymAcademy.controller.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.category_training.Category_TrainingService;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class NewCategory {

    @Autowired
    private Category_TrainingService category_trainingService ;


    @Autowired
    private ImageUploader imageUploader ;

    public static String uploadDirectory = "D://Workspace_spring//proxym_university//Proxym_University//upload";
    @GetMapping("/new-category")
    public String NewCategoryTraining(TrainingCategoryDto trainingCategoryDto, Model model){
        List<TrainingCategory> categoryList=category_trainingService.findAll() ;
        model.addAttribute("categoryList",categoryList) ;
        return "new-Category";
    }

    @PostMapping("/new-category")
    public String NewCategoryTraining(@Valid TrainingCategoryDto trainingCategory, BindingResult result) throws Exception{
        MultipartFile file=trainingCategory.getPhoto() ;
        category_trainingService.create(trainingCategory,imageUploader.ImageUpload(file,uploadDirectory) );
        return "redirect:new-category" ;
    }

}
