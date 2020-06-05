package tn.Proxym.ProxymAcademy.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.project.ProjectDao;
import tn.Proxym.ProxymAcademy.model.Project;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao ;
    @Override
    public Optional<Project> findById(long id) {
        return projectDao.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Project create(Project entity) {
        return projectDao.create(entity);
    }

    @Override
    public Project update(Project entity) {
        return projectDao.update(entity);
    }

    @Override
    public void delete(Project entity) {
        projectDao.delete(entity);

    }

    @Override
    public void deleteById(long entityId) {
        projectDao.deleteById(entityId);

    }

    @Override
    public List<Project> ProjectsByUser(Long id) {
        return projectDao.ProjectsByUser(id);
    }
}
