package com.example.task1.peliod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;

    private int amount;

    private int typeId;

    private double price;

    private int characterId;
}
