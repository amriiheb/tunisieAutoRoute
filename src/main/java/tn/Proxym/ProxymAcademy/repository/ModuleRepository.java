package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.Proxym.ProxymAcademy.model.Module;
import tn.Proxym.ProxymAcademy.model.Trainer;

public interface ModuleRepository extends JpaRepository<Module,Long> {
}
