package com.iuri.authentication.service;

import com.iuri.authentication.model.User;
import com.iuri.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByname(String name){
        return userRepository.findByName(name).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }

    public User assignRoleToUser(String name, String roleName){
        var role = roleService.findByname(roleName);
        var user = findByname(name);

        if (user.getRoles() == null){
            user.setRoles(new HashSet<>());
        }

        user.getRoles().add(role);
        return userRepository.save(user);
    }
}
