package com.spring.restaurant.repository;

import com.spring.restaurant.dao.MenuDetails;
import com.spring.restaurant.dto.MenuDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<MenuDetails,Integer> {

    MenuDetails findAllById(Integer id);
}
