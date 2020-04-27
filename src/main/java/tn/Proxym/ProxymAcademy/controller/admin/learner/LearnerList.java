package tn.Proxym.ProxymAcademy.controller.admin.learner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.learner.LearnerService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LearnerList {

    @Autowired
    LearnerService learnerService ;

    @GetMapping("/learners")
    public String LearnerList(Model model){
        List<Learner> learners=learnerService.findAll() ;
        model.addAttribute("learners",learners) ;
        return "learners" ;
    }


}
