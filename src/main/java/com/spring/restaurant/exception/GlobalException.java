package com.spring.restaurant.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String exception(Model model, MethodArgumentNotValidException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "employee-register";
    }

    @ExceptionHandler(value = CustomException.class)
    public String exception(Model model, CustomException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "forward:/api/employee/add";
    }

    @ExceptionHandler(value = BindException.class)
    public String exception(Model model, BindException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "employee-register";
    }
}
