package tn.Proxym.ProxymAcademy.controller.admin.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.category_training.Category_TrainingService;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class Category {

    @Autowired
    private Category_TrainingService category_trainingService ;
    @Autowired
    private ImageUploader imageUploader ;
    private Path rootLocation;
    List<String> stringss ;

    public static String uploadDirectory = "D://Workspace_spring//proxym_university//Proxym_University//upload//category";


    @GetMapping("/training-category")
    public String CategoryList(Model model,TrainingCategoryDto trainingCategory){
        List<TrainingCategory> categoryList=category_trainingService.findAll() ;
        model.addAttribute("categoryList",categoryList) ;
        return "categorylist";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {

        Path file = this.rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        return ResponseEntity
                .ok()
                .body(resource);
    }
    @PostMapping("/new-training-category")
    public String NewCategoryTraining(@Valid TrainingCategoryDto trainingCategory, BindingResult result) throws Exception{
        MultipartFile file=trainingCategory.getPhoto() ;
        category_trainingService.create(trainingCategory,imageUploader.ImageUpload(file,uploadDirectory) );
        return "redirect:/admin/training/training-category" ;
    }
    @GetMapping("category/delete")
    public String delete(@RequestParam(name="id")String id) {
        Long id1=Long.parseLong(id) ;
        category_trainingService.Drop(id1);
        return "redirect:/admin/training/training-category";
    }

}
