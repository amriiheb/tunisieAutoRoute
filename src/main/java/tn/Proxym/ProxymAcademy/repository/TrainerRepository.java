package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Trainer;
@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {

}
