package tn.Proxym.ProxymAcademy.controller.training;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import tn.Proxym.ProxymAcademy.dto.module.ModuleCreateDto;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.model.Module;
import tn.Proxym.ProxymAcademy.model.Trainer;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.service.module.ModuleService;
import tn.Proxym.ProxymAcademy.service.training.TrainingService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/training")
public class TrainingDetails {
    @Autowired
    TrainingService trainingService ;
    @Autowired
    ModuleService moduleService ;

    Training training ;
    Module module;

    @GetMapping("/trainingDetails")
    public String TrainingDetails(@RequestParam(name="id")String id, ModuleCreateDto moduleCreateDto, Model model) {
        Long id1=Long.parseLong(id) ;
        training=trainingService.findById(id1).get() ;
        Set<Module>modules=training.getModules() ;
        model.addAttribute("training",training) ;
        model.addAttribute("modules",modules) ;


        return "training-details";
    }
    @PostMapping("/add-module")
    public String NewModule( ModuleCreateDto moduleCreateDto, BindingResult result) throws Exception{
        Mapper mapper=new DozerBeanMapper() ;
        Module module=mapper.map(moduleCreateDto,Module.class);
        module.setTraining(training);
        moduleService.create(module) ;
        String  url="redirect:/admin/training/trainingDetails?id="+training.getId() ;
        return url ;
    }
    @GetMapping("/module/delete")
    public String deleteModule(@RequestParam(name="id")String id) {
        Long id1=Long.parseLong(id) ;
       moduleService.Drop(id1);
        return "redirect:/admin/training/trainingDetails?id="+training.getId();
    }
    @GetMapping("/module/edit")
    public String editModule(@RequestParam(name="id")String id,Model model) {
        Long id1=Long.parseLong(id) ;
        module=moduleService.findById(id1).get();
        model.addAttribute("post",module );

        return "edit_module" ;
    }

    @PostMapping("/content")
    public String save(Module post, Model model) {
        module.setContained(post.getContained());
        moduleService.update(module) ;
        return "redirect:/admin/training/trainingDetails?id="+training.getId();
    }
}
