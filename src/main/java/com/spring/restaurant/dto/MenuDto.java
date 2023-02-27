package com.spring.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private int id;

    @NotNull(message = "username not empty")
    private String food;
    @NotNull(message = "Enter price")
    private int price;
}
