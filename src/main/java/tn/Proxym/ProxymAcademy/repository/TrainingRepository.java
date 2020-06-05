package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

@Repository
public interface TrainingRepository   extends JpaRepository<Training,Long> {
    @Query("select e from Training  e where e.trainer.id=?1")
    List<Training> myTrainings(Long id) ;
}
