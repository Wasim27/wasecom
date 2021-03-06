package com.ecommerce.wasecom.category;

import com.ecommerce.wasecom.category.exception.CategoryNotFoundException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryController {

  @Autowired
  CategoryService categoryService;

  @GetMapping("/categories")
  public String categoriesPage(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    return "categories";
  }

  @GetMapping("/categories/add")
  public String getAddCategory(Model model) {
    model.addAttribute("category", new Category());
    return "categoriesAdd";
  }

  @PostMapping("/categories/add")
  public String postAddCategory(@ModelAttribute("category") Category category) {
    categoryService.addCategory(category);
    return "redirect:/admin/categories";
  }

  @GetMapping("/categories/delete/{id}")
  public String deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return "redirect:/admin/categories";
  }
  @GetMapping("/categories/update/{id}")
  public String updateCategory(@PathVariable Long id, Model model, HttpServletResponse response) {
    Optional<Category> category = categoryService.getCategory(id);

    if(category.isPresent()) {
      model.addAttribute("category", category.get());
      return "categoriesAdd";
    } else {
      throw new CategoryNotFoundException();
    }
  }
}
