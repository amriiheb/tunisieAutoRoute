package tn.Proxym.ProxymAcademy.dto.dao.admin;

import tn.Proxym.ProxymAcademy.dto.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Admin;

import java.util.List;

public interface AdminDao extends IOperations<Admin> {
    List<Admin> FindAllWithInheritance() ;
    
}
