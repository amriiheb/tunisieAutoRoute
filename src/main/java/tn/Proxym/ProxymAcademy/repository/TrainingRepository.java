package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Training;

@Repository
public interface TrainingRepository   extends JpaRepository<Training,Long> {
}
