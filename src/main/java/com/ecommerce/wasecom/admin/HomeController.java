package com.ecommerce.wasecom.admin;

import com.ecommerce.wasecom.category.CategoryService;
import com.ecommerce.wasecom.global.GlobalData;
import com.ecommerce.wasecom.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
  @Autowired
  CategoryService categoryService;
  @Autowired
  ProductService productService;

  @GetMapping({"/", "/home"})
  public String home(Model model) {
    model.addAttribute("cartCount", GlobalData.cart.size());
    return "index";
  }

  @GetMapping("/shop")
  public String shop(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("products", productService.getAllProducts());
    model.addAttribute("cartCount", GlobalData.cart.size());
    return "shop";
  }

  @GetMapping("/shop/category/{id}")
  public String shopByCategory(@PathVariable Long id, Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("products", productService.getProductByCategory(id));
    model.addAttribute("cartCount", GlobalData.cart.size());
    return "shop";
  }

  @GetMapping("/shop/view/{id}")
  public String viewProduct(@PathVariable Long id, Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("product", productService.getProduct(id).get());
    model.addAttribute("cartCount", GlobalData.cart.size());
    return "singleProductView";
  }
}
