package com.spring.restaurant.repository;

import com.spring.restaurant.dao.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {

    UserDetails findByusername(String username);

    boolean existsByusername(String userName);
}
