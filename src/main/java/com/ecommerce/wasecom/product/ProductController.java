package com.ecommerce.wasecom.product;

import com.ecommerce.wasecom.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {

  @Autowired
  ProductService productService;
  @Autowired
  CategoryService categoryService;

  @GetMapping("/products")
  public String productsPage(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @GetMapping("/products/add")
  public String getAddProduct(Model model) {
    model.addAttribute("productDto", new ProductDto());
    model.addAttribute("categories", categoryService.getAllCategories());
    return "productsAdd";
  }

  @PostMapping("/products/add")
  public String postAddProduct(@ModelAttribute("productDto") ProductDto productDto) {
    Product product = new Product();
    product.setId(productDto.getId());
    product.setName(productDto.getName());
    product.setCategory(categoryService.getCategory(productDto.getCategoryId()).get());
    product.setDescription(productDto.getDescription());
    product.setPrice(productDto.getPrice());
    product.setWeight(productDto.getWeight());
    product.setQuantity(productDto.getQuantity());
    product.setProductImage(productDto.getProductImage());

    productService.addProduct(product);
    return "redirect:/admin/products";
  }
}
