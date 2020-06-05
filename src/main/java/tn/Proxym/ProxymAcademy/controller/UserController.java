package tn.Proxym.ProxymAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.dto.UserCreateDto;
import tn.Proxym.ProxymAcademy.dto.VerifyCodeDto;
import tn.Proxym.ProxymAcademy.model.User;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("sign-up")
    public String signUp(UserCreateDto userCreateDto, Model model){
        return "sign-up" ;
    }
    @PostMapping("sign-up")
    public String signUp(@Valid UserCreateDto userCreateDto, BindingResult result) throws  Exception{
        if(result.hasErrors()){
            return "sign-up" ;
        }
        User account = userService.createMember(userCreateDto);
        userCreateDto.setId(account.getId());
        return "redirect:/verify-code";
    }
    @GetMapping("verify-code")
    public String verifyCode(Model model, VerifyCodeDto verifyCodeDto) {

        return "verify-code";
    }

    @PostMapping("verify-code")
    public String verifyCodeAction(Model model, @Valid VerifyCodeDto verifyCodeDto, BindingResult result) {
        if(result.hasErrors()) {
            return "verify-code";
        }

        userService.verifyCode(verifyCodeDto);

        return "redirect:/login";
    }


    @GetMapping("login")
    public String login(Model model, HttpServletRequest request){
        return "login" ;
    }


}












