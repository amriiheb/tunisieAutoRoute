package tn.Proxym.ProxymAcademy.controller.admin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.service.learner.LearnerService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class TrainerList {
    @Autowired
    TrainerService trainerService ;
    @GetMapping("/trainers")
    public String TrainerList(Model model) {
        List<Trainer> trainers = trainerService.findAll();
        model.addAttribute("trainers", trainers);
        return "trainers";
    }

    @GetMapping("/trainers/delete")
    public String delete(@RequestParam(name="id")String id) {
        System.out.println(id);
        Long id1=Long.parseLong(id) ;
        trainerService.Drop(id1);
        return "redirect:/admin/trainers";


    }
}
