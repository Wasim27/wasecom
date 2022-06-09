package com.ecommerce.wasecom.product;

import com.ecommerce.wasecom.resources.FileUploadUtil;
import com.ecommerce.wasecom.category.CategoryService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class ProductController {

  public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

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
  public String postAddProduct(@ModelAttribute("productDto") ProductDto productDto,
      @RequestParam("productImage") MultipartFile multipartFile,
      @RequestParam("productImageName") String productImageName)
      throws IOException {

    Product product = new Product();
    product.setId(productDto.getId());
    product.setName(productDto.getName());
    product.setCategory(categoryService.getCategory(productDto.getCategoryId()).get());
    product.setDescription(productDto.getDescription());
    product.setPrice(productDto.getPrice());
    product.setWeight(productDto.getWeight());
    product.setQuantity(productDto.getQuantity());
    
    String fileName;
    if(!multipartFile.isEmpty()) {
      fileName = multipartFile.getOriginalFilename();
      FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    } else {
      fileName = productImageName;
    }
    product.setProductImageName(fileName);

    productService.addProduct(product);

    return "redirect:/admin/products";
  }

  @GetMapping("/products/update/{id}")
  public String updateProduct(@PathVariable Long id, Model model, HttpServletResponse response) {
    Product product = productService.getProduct(id).get();
    ProductDto productDto = new ProductDto();
    productDto.setId(product.getId());
    productDto.setName(product.getName());
    productDto.setCategoryId(product.getCategory().getId());
    productDto.setDescription(product.getDescription());
    productDto.setPrice(product.getPrice());
    productDto.setWeight(product.getWeight());
    productDto.setQuantity(product.getQuantity());
    productDto.setProductImageName(product.getProductImageName());

    model.addAttribute("productDto", productDto);
    model.addAttribute("categories", categoryService.getAllCategories());

    return "productsAdd";
  }

  @GetMapping("/products/delete/{id}")
  public String deleteCategory(@PathVariable Long id) {
    productService.deleteProduct(id);
    return "redirect:/admin/products";
  }
}
