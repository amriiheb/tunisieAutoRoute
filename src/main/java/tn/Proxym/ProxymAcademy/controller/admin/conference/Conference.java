package tn.Proxym.ProxymAcademy.controller.admin.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import tn.Proxym.ProxymAcademy.dto.conference.ConferenceDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.security.UserPrincipal;
import tn.Proxym.ProxymAcademy.service.conference.ConferenceService;
import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/conference")
public class Conference {
    @Autowired
    ConferenceService conferenceService ;
    @Autowired
    ImageUploader imageUploader ;
    public static String uploadDirectory = "/home/iheb/Desktop/Proxym_University/upload/conference";

    @GetMapping("/conferencelist")
    public String ConferenceList(Model model, ConferenceDto conferenceDto){
        List<tn.Proxym.ProxymAcademy.model.Conference> conferenceList=conferenceService.findAll() ;
        model.addAttribute("conferencelist",conferenceList) ;
        return "conferencelist";
    }

    @PostMapping("/new-conference")
    public String NewConference(@Valid ConferenceDto conferenceDto, BindingResult result) throws  Exception {
        MultipartFile file=conferenceDto.getPhoto() ;
        conferenceService.create(conferenceDto,imageUploader.ImageUpload(file,uploadDirectory) );



        return "redirect:/admin/conference/conferencelist" ;
    }
}
