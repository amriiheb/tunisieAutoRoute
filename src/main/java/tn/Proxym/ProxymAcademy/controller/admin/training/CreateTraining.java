package tn.Proxym.ProxymAcademy.controller.admin.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.dao.training.TrainingDao;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.category_training.Category_TrainingService;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;
import tn.Proxym.ProxymAcademy.service.training.TrainingService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class CreateTraining {
    public static String uploadDirectory = "D://Workspace_spring//proxym_university//Proxym_University//upload//training";
@Autowired
    ImageUploader imageUploader ;
    @Autowired
    private TrainerService trainerService ;
@Autowired
private Category_TrainingService category_trainingService ;
@Autowired
private TrainingService trainingService ;


    @GetMapping("/new-training")
    public String NewTraining(TrainingCreateDtoA trainingCreateDtoA, Model model){
        List<Trainer> trainers =trainerService.FindAllWithInheritance() ;
         model.addAttribute("trainers",trainers) ;
         List<TrainingCategory> trainingCategoryList=category_trainingService.findAll();
         model.addAttribute("category_list",trainingCategoryList);

        return  "new-training-creation" ; }
    @PostMapping("/new-training")
    public String NewTraining(@Valid TrainingCreateDtoA trainingCreateDtoA, BindingResult result) throws  Exception {
//trainingService.create(trainingCreateDtoA) ;
        MultipartFile file=trainingCreateDtoA.getPhoto() ;
        trainingService.create(trainingCreateDtoA) ;


        return "redirect:new-training" ;
    }



}
