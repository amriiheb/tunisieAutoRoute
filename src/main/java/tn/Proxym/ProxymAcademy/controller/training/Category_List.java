package tn.Proxym.ProxymAcademy.controller.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.category_training.Category_TrainingService;

import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class Category_List {
    @Autowired
    private Category_TrainingService category_trainingService ;

    @GetMapping("/category_list")
    public String CategoryList( Model model){
        List<TrainingCategory> categoryList=category_trainingService.findAll() ;
        model.addAttribute("categoryList",categoryList) ;
        return "category-list";
    }


}
