package tn.Proxym.ProxymAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.AdminCreateDto;
import tn.Proxym.ProxymAcademy.dto.LearnerCreateDto;
import tn.Proxym.ProxymAcademy.dto.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.learner.LearnerService;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/develop")
public class DeveloperController {


    @Autowired
    private AdminService adminService;
    @GetMapping("addadmin")
    public String signUp(AdminCreateDto adminCreateDto, Model model){
        return "adminAdd" ;
    }


    @PostMapping("addadmin")
    public String signUp(@Valid AdminCreateDto adminCreateDto, BindingResult result) throws  Exception{
        if(result.hasErrors()){
            return "adminAdd" ;
        }

        return "login";
    }
}
