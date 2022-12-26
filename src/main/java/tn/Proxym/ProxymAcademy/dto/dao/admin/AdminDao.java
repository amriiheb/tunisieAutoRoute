package tn.Proxym.ProxymAcademy.dao.admin;

import tn.Proxym.ProxymAcademy.dao.IOperations;
import tn.Proxym.ProxymAcademy.model.Admin;

import java.util.List;

public interface AdminDao extends IOperations<Admin> {
    List<Admin> FindAllWithInheritance() ;
    
}
