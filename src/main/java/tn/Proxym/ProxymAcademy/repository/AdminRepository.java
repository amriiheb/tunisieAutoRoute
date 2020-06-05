package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.Proxym.ProxymAcademy.model.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("select  e from Admin e where e.dtype=Admin")
    List<Admin> FindJustAdmin() ;


}
