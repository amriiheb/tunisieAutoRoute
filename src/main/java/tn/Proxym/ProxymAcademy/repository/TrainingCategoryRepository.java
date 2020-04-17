package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
@Repository
public interface TrainingCategoryRepository  extends JpaRepository<TrainingCategory,Long> {

}
