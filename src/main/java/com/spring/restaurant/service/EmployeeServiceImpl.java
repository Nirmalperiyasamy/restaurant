package com.spring.restaurant.service;

import com.spring.restaurant.dao.UserDetails;
import com.spring.restaurant.dto.UserDto;
import com.spring.restaurant.exception.CustomException;
import com.spring.restaurant.repository.RoleRepo;
import com.spring.restaurant.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements UserDetailsService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;

    public boolean isUsernameExist(String userName) {
        return userRepo.existsByusername(userName);
    }

    public UserDto addEmployee(UserDto dto) {
        if (isUsernameExist(dto.getUsername())) throw new CustomException("User already registered");

        UserDetails details = new UserDetails();
        BeanUtils.copyProperties(dto, details);
        String encoded = new BCryptPasswordEncoder().encode(dto.getPassword());
        details.setPassword(encoded);
        details.setRoleDetails(roleRepo.findById(1).get());
        userRepo.save(details);
        BeanUtils.copyProperties(details, dto);

        return dto;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails
    loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails details = userRepo.findByusername(username);
        List<GrantedAuthority> authorities = List.of((GrantedAuthority) () -> details.getRoleDetails().getRole().name());
        return new User(details.getUsername(), details.getPassword(), authorities);
    }
}
