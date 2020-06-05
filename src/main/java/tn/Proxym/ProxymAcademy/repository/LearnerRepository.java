package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.User;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Long> {
    @Query("SELECT u FROM User u WHERE u.dtype=Learner")
    List<Learner> findJustLearners();

}
