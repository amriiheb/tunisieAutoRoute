package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Learner;
import tn.Proxym.ProxymAcademy.model.User;
@Repository
public interface LearnerRepository extends JpaRepository<Learner,Long> {
}
