package tn.Proxym.ProxymAcademy.controller.admin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.service.admin.AdminService;
import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminList {
    @Autowired
    AdminService adminService ;
    @GetMapping("/admins")
    public String TrainerList(Model model) {
        List<Admin> admins = adminService.findAll();
        model.addAttribute("admins", admins);
        return "admins";
    }

    @GetMapping("/admins/delete")
    public String delete(@RequestParam(name="id")String id) {
        System.out.println(id);
        Long id1=Long.parseLong(id) ;
         adminService.Drop(id1);
        return "redirect:/admin/admins";


    }
}
