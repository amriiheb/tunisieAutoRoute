package tn.Proxym.ProxymAcademy.dao.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.dao.admin.AdminDao;
import tn.Proxym.ProxymAcademy.model.Admin;
import tn.Proxym.ProxymAcademy.repository.AdminRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class AdminDaoImpl  implements AdminDao {

    @Autowired
    AdminRepository adminRepository ;
    @Override
    public Optional<Admin> findById(long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.FindJustAdmin();
    }

    @Override
    public List<Admin> FindAllWithInheritance() {
       return adminRepository.findAll() ;
    }

    @Override
    public Admin create(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public Admin update(Admin entity) {
        return null;
    }

    @Override
    public void delete(Admin entity) {
          adminRepository.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {

    }
}
