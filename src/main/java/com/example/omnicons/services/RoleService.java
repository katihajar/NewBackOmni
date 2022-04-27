package com.example.omnicons.services;

import com.example.omnicons.bean.Role;

import java.util.Collection;

public interface RoleService {
    Role save(Role role);
    void save(Collection<Role> roles);
    Role findByAuthority(String authority);
}
