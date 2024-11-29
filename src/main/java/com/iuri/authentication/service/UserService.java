package com.iuri.authentication.service;

import com.iuri.authentication.model.User;
import com.iuri.authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findByUsername(User user){
        return userRepository.findByUsername(user.getUsername()).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found")
        );
    }
}
