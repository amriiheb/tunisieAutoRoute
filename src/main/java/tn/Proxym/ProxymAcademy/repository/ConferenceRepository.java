package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.Proxym.ProxymAcademy.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
