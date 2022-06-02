package com.ecommerce.wasecom.category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public void addCategory(Category category) {
    categoryRepository.save(category);
  }

  public Optional<Category> getCategory(Long id) {
    return categoryRepository.findById(id);
  }

  public void deleteCategory(Long id) { categoryRepository.deleteById(id);}
}
