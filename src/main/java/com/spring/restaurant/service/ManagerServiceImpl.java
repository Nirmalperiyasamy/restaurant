package com.spring.restaurant.service;

import com.spring.restaurant.dao.MenuDetails;
import com.spring.restaurant.dto.MenuDto;
import com.spring.restaurant.repository.MenuRepo;
import com.spring.restaurant.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl {
    @Autowired
    private MenuRepo menuRepo;

    public MenuDto addMenu(MenuDto dto) {
        MenuDetails details = new MenuDetails();
        BeanUtils.copyProperties(dto, details);
        details = menuRepo.save(details);
        BeanUtils.copyProperties(details, dto);
        return dto;
    }

    public List<MenuDto> getAllMenus() {
        List<MenuDetails> details = menuRepo.findAll();
        List<MenuDto> dto = convertToDtoList(details);
        return dto;
    }

    public MenuDto convertToDto(MenuDetails detail) {
        MenuDto dto = new MenuDto();
        dto.setId(detail.getId());
        dto.setFood(detail.getFood());
        dto.setPrice(detail.getPrice());
        return dto;
    }

    public List<MenuDto> convertToDtoList(List<MenuDetails> detail) {
        List<MenuDto> dto = new ArrayList<>();
        for (MenuDetails menuDetails : detail) {
            dto.add(convertToDto(menuDetails));
        }
        return dto;
    }

    public MenuDto getById(Integer id) {
        MenuDetails details = menuRepo.findAllById(id);
        MenuDto dto = convertToDto(details);
        return dto;
    }

    public MenuDto updateMenu(MenuDto existMenu) {
        MenuDetails details = new MenuDetails();
        BeanUtils.copyProperties(existMenu, details);
        menuRepo.save(details);
        return existMenu;
    }

    public void deleteById(int id) {
        menuRepo.deleteById(id);
    }
}
