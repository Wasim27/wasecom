package com.ecommerce.wasecom.product;

import lombok.Data;

@Data
public class ProductDto {
  private Long id;
  private String name;
  private String description;
  private double price;
  private double weight;
  private int quantity;
  private String productImage;

  private long categoryId;
}
