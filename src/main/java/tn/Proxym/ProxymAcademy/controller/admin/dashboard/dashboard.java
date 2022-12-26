package tn.Proxym.ProxymAcademy.controller.admin.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.Proxym.ProxymAcademy.model.Vehicle;
import tn.Proxym.ProxymAcademy.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/dashboard")
public class dashboard {
    @Autowired
    VehicleRepository vehicleRepository;
    private static final int LIMIT = 500;

    @GetMapping("")
    public String dashboard(Model model) {
        Page<Vehicle> page = vehicleRepository.findAll(PageRequest.of(0, LIMIT, Sort.by(Sort.Order.asc("date"))));
        List<Vehicle> vehicleList = Optional.of(page.getContent()).get();
        model.addAttribute("vehicles", vehicleList);
        return "adminDashboard";
    }
}
