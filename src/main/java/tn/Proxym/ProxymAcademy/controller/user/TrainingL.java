package tn.Proxym.ProxymAcademy.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.service.training.TrainingService;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/user/training")
public class TrainingL {
    @Autowired
    TrainingService trainingService ;
    private Path rootLocation;


}
