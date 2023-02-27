package com.spring.restaurant.repository;

import com.spring.restaurant.dao.RoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleDetails,Integer> {
}
