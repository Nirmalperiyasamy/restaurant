package com.spring.restaurant.bootstrap;

import com.spring.restaurant.dao.UserDetails;
import com.spring.restaurant.repository.RoleRepo;
import com.spring.restaurant.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BootStrap {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    private void postConstructor() {
        if (!isUsernameExist("Gokul")) {
            UserDetails admin = new UserDetails();
            admin.setUsername("Gokul");
            admin.setPassword(passwordEncoder.encode("1234"));
           admin.setRoleDetails(roleRepo.findById(2).get());
            userRepo.save(admin);
        }

    }

    private boolean isUsernameExist(String username) {
        return userRepo.existsByusername(username);
    }
}
