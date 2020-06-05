package tn.Proxym.ProxymAcademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.Proxym.ProxymAcademy.model.Project;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;

public interface ProjectRepository  extends JpaRepository<Project,Long> {
    @Query("select e from Project  e where e.user.id=?1")
    List<Project> ProjectsByUser(Long id) ;
}
