package com.spring.restaurant.controller;

import com.spring.restaurant.dao.MenuDetails;
import com.spring.restaurant.dto.MenuDto;
import com.spring.restaurant.service.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.spring.restaurant.constants.Constants.*;

@Controller
@RequestMapping(MANAGER)
public class ManagerController {
    @Autowired
    private ManagerServiceImpl managerService;

    @RequestMapping(PING)
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok("manager pong");
    }

    @GetMapping(MENU)
    public String allMenu(Model model) {
        List<MenuDto> menu = managerService.getAllMenus();
        model.addAttribute("menus", menu);
        return "manager-menulist";
    }

    @GetMapping(ADDMENU)
    public String getAll(Model model) {
        MenuDto dto = new MenuDto();
        model.addAttribute("menu", dto);
        return "add-menu";
    }

    @PostMapping(MENU)
    public String menu(@Valid @ModelAttribute MenuDto dto) {
        managerService.addMenu(dto);
        return "redirect:menu";
    }


    @GetMapping(EDITMENU)
    public String editMenu(@PathVariable int id, Model model) {
        model.addAttribute("menu", managerService.getById(id));
        return "edit-menu";
    }

    @PostMapping(UPDATEMENU)
    public String updateMenu(@PathVariable int id, @ModelAttribute("menu") MenuDto dto, Model model) {
        MenuDto existMenu = managerService.getById(id);
        existMenu.setId(id);
        existMenu.setFood(dto.getFood());
        existMenu.setPrice(dto.getPrice());
        managerService.updateMenu(existMenu);
        return "redirect:/api/manager/menu";
    }

    @GetMapping(DELETEMENU)
    public String deleteMenu(@PathVariable int id) {
        managerService.deleteById(id);
        return "redirect:/api/manager/menu";
    }
}
