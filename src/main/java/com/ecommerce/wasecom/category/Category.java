package com.ecommerce.wasecom.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Category")
@Data
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name= "category_id")
  private Long id;

  private String name;

}
