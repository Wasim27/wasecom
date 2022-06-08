package com.ecommerce.wasecom.product;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> getProductByCategory(Long id) {
    return productRepository.findAllByCategory_Id(id);
  }

  public void addProduct(Product product) {
    productRepository.save(product);
  }

  public Optional<Product> getProduct(Long id) {
    return productRepository.findById(id);
  }

  public void deleteProduct(Long id) { productRepository.deleteById(id);}
}
