package tn.Proxym.ProxymAcademy.controller.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.category_training.Category_TrainingService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class TrainingControllerA {
    @Autowired
    private TrainerService trainerService ;
@Autowired
private Category_TrainingService category_trainingService ;

    @GetMapping("/new-training")
    public String NewTraining(TrainingCreateDtoA trainingCreateDtoA, Model model){
        List<Trainer> trainers =trainerService.findAll() ;
         model.addAttribute("trainers",trainers) ;
         List<TrainingCategory> trainingCategoryList=category_trainingService.findAll();
         model.addAttribute("category_list",trainingCategoryList);

        return  "new-training-creation" ; }
    @PostMapping("/new-training")
    public String NewTraining(@Valid TrainingCreateDtoA trainingCreateDtoA, BindingResult result) throws  Exception {
        return "" ;
    }



}
