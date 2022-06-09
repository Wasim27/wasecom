package com.ecommerce.wasecom.product;

import com.ecommerce.wasecom.category.Category;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Product")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name= "product_id")
  private Long id;

  private String name;
  private String description;
  private double price;
  private double weight;
  private Integer quantity;
  private String productImageName;

  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "category_id")
  private Category category;

}
