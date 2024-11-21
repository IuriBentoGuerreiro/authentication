package com.iuri.authentication.service;

import com.iuri.authentication.model.Role;
import com.iuri.authentication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByname(String name){
        return roleRepository.findByName(name);
    }
}
