package tn.Proxym.ProxymAcademy.controller.admin.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.training.TrainingService;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping("/admin/training")
public class TrainingList {
    @Autowired
    TrainingService trainingService ;
    private Path rootLocation;

    @GetMapping("/training-list")
    public String TrainingList(Model model){
        List<Training> TrainingList=trainingService.findAll();
        model.addAttribute("trainingList",TrainingList) ;
        return "trainingList";
    }

    @GetMapping("/delete/training")
    public String delete(@RequestParam(name="id")String id) {
        Long id1=Long.parseLong(id) ;
        trainingService.drop(id1);
        return "redirect:/admin/training/training-list";
    }
}
