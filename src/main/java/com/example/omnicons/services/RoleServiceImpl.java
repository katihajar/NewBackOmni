package com.example.omnicons.services;


import com.example.omnicons.Dao.RoleDao;

import com.example.omnicons.bean.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role save(Role role) {
        Role loadedRole = roleDao.findByAuthority(role.getAuthority());
        if(loadedRole == null){
            return roleDao.save(role);
        }else{
            return loadedRole;
        }
    }

    @Override
    public void save(Collection<Role> roles) {
        if(roles!=null && !roles.isEmpty()){
            for (Role role :roles) {
                Role foundedRole = findByAuthority(role.getAuthority());
                if (foundedRole != null) {
                    role.setId(foundedRole.getId());
                }else{
                    roleDao.save(role);
                }
            }
        }
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleDao.findByAuthority(authority);
    }
}
