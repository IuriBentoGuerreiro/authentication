package com.iuri.authentication.service;

import com.iuri.authentication.enuns.RoleName;
import com.iuri.authentication.model.Role;
import com.iuri.authentication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByname(RoleName roleName){
        return roleRepository.findByRoleName(roleName).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }
}
