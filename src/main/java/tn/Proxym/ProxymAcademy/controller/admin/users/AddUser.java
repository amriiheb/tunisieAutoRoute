package tn.Proxym.ProxymAcademy.controller.admin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.admin.UserCreateDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AddUser {


    @Autowired
    AdminService adminService;


    @GetMapping("/new-user")
    public String signUp(UserCreateDto userCreateDto, Model model) {
        return "add-user";
    }

    @PostMapping("/new-user")
    public String signUp(@Valid UserCreateDto userCreateDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "add-user";
        }
        if (userCreateDto.getType().equals("admin")) {
            Admin admin = adminService.createAdmin(userCreateDto);
        }
        return "redirect:dashboard";
    }
}
