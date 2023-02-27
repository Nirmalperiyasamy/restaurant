package com.spring.restaurant.controller;

import com.spring.restaurant.dto.MenuDto;
import com.spring.restaurant.dto.UserDto;
import com.spring.restaurant.service.EmployeeServiceImpl;
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
@RequestMapping(EMPLOYEE)
public class EmpolyeeController {

    private final EmployeeServiceImpl employeeService;

    private final ManagerServiceImpl managerService;

    public EmpolyeeController(EmployeeServiceImpl employeeService, ManagerServiceImpl managerService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
    }
    @RequestMapping(PING)
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok("PONG EMLPOYEE");
    }

    @RequestMapping(ADDEMPLOYEE)
    public String index() {
        return "employee-register";
    }

    @PostMapping(ADDEMPLOYEE)
    public String addEmployee(@Valid @ModelAttribute UserDto dto) {
        employeeService.addEmployee(dto);
        return "redirect:/login";
    }

    @GetMapping(MENU)
    public String allMenu(Model model) {
        List<MenuDto> menu = managerService.getAllMenus();
        model.addAttribute("menus", menu);
        return "employee-menulist";
    }

}
