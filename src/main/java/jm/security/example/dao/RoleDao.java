package jm.security.example.dao;

import jm.security.example.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleById(Long id);
    List<Role> listRoles();
}
