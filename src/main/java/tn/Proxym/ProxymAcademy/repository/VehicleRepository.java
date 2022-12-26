package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Vehicle;

@Repository

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findAll(Pageable pageable);
}
