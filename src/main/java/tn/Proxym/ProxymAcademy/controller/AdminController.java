package tn.Proxym.ProxymAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.LearnerCreateDto;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.learner.LearnerService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    LearnerService learnerService ;

    @Autowired
    AdminService adminService ;
    @Autowired
    TrainerService trainerService ;

    @GetMapping("/dashboard")
    public String Dashboard(Model model ){
        return "plain-page";
    }

    @GetMapping("/learners")
    public String LearnerList(Model model){
        List<Learner> learners=learnerService.findAll() ;
        model.addAttribute("learners",learners) ;
        return "learners" ;
    }
    @GetMapping("/trainers")
    public String TrainerList(Model model){
        List<Trainer> trainers=trainerService.findAll() ;
        model.addAttribute("trainers",trainers) ;
        return "trainers" ;
    }
    @GetMapping("/admins")
    public String AdminsList(Model model){
        List<Admin> adminList=adminService.findAll() ;
        model.addAttribute("admins",adminList) ;
        return "admins.html" ;
    }

    @GetMapping("/new-user")
    public String signUp(UserCreateDto userCreateDto, Model model){
        return "add-user" ;
    }
    @PostMapping("/new-user")
    public String signUp(@Valid UserCreateDto userCreateDto, BindingResult result) throws  Exception{
        if(result.hasErrors()){
            return "add-user" ;
        }

        if(userCreateDto.getType().equals("admin")){
         Admin admin=adminService.createAdmin(userCreateDto) ;
        }
       else  if(userCreateDto.getType().equals("learner")){
            Learner learner = learnerService.create(userCreateDto) ;
        }
       else if(userCreateDto.getType().equals("trainer")){
            Trainer trainer=trainerService.create(userCreateDto) ;
        }

        return "redirect:dashboard";
    }






    }
