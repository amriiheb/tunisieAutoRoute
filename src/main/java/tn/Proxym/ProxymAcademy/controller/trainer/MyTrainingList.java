package tn.Proxym.ProxymAcademy.controller.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.security.UserPrincipal;
import tn.Proxym.ProxymAcademy.service.training.TrainingService;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;


@Controller
@RequestMapping("/trainer/MyTrainings")

public class MyTrainingList {

    @Autowired
    TrainingService trainingService ;
    private Path rootLocation;

    @GetMapping("/training-list")
    public String MyTrainingList(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal=(UserPrincipal) authentication.getPrincipal() ;
       List<Training> myTrainings= trainingService.myTrainings(userPrincipal.getId()) ;
        model.addAttribute("myTrainings",myTrainings) ;
        return "myTrainings-list";
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {

        Path file = this.rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        return ResponseEntity
                .ok()
                .body(resource);
    }

}
