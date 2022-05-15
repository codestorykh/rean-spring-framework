package com.rean.data;

import lombok.Data;

@Data
public class Product {

    private Integer id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
