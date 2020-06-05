package tn.Proxym.ProxymAcademy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.dto.user.UserUpdateDto;
import tn.Proxym.ProxymAcademy.model.Project;
import tn.Proxym.ProxymAcademy.model.Skill;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.security.UserPrincipal;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;
import tn.Proxym.ProxymAcademy.service.project.ProjectService;
import tn.Proxym.ProxymAcademy.service.skill.SkillService;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class Profile {

    @Autowired
    SkillService skillService ;
    @Autowired
    ProjectService projectService ;
    @Autowired
    UserService userService ;
    @Autowired
    ImageUploader imageUploader ;


    public static String uploadDirectory = "/home/iheb/Desktop/Proxym_University/upload/profile";


    @GetMapping("/profile")
    public String Profile(@ModelAttribute("newproject") Project newproject,Model model ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
        List<Skill> skills=skillService.SkillsByUser(userPrincipal.getId()) ;
        List<Project> projects=projectService.ProjectsByUser(userPrincipal.getId()) ;
        User user=userService.findById(userPrincipal.getId()).get() ;
        UserUpdateDto userUpdateDto =new UserUpdateDto() ;
        model.addAttribute("userUpdateDto",userUpdateDto) ;
        model.addAttribute("skills",skills) ;
        model.addAttribute("projects",projects) ;
        model.addAttribute("user",user) ;
        Skill newskill=new Skill() ;
        model.addAttribute("newskill",newskill) ;
        Skill editSkill=new Skill() ;
        model.addAttribute("editSkill",editSkill) ;

        return "myprofile";
    }
    @PostMapping("/addskill")
    public String NewSkill(@Valid Skill newskill, BindingResult result) throws  Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
        newskill.setUser(userService.findById(userPrincipal.getId()).get());
        skillService.create(newskill) ;
        return "redirect:/user/profile" ;
    }

    @PostMapping("/addproject")
    public String NewProject(@Valid Project newproject, BindingResult result) throws  Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
        newproject.setUser(userService.findById(userPrincipal.getId()).get());
        projectService.create(newproject) ;
        return "redirect:/user/profile" ;
    }


    @PostMapping("/updatephoto")
    public String user(UserUpdateDto userUpdateDto, BindingResult result) throws  Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
        User user=userService.findById(userPrincipal.getId()).get() ;
        MultipartFile file=userUpdateDto.getPhoto() ;

        user.setPhotoUrl(imageUploader.ImageUpload(file,uploadDirectory));
        userService.updateUser(user);
        return "redirect:/user/profile" ;


    }



    }
