package com.ecommerce.wasecom.cart;

import com.ecommerce.wasecom.product.Product;
import com.ecommerce.wasecom.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
  @Autowired
  ProductService productService;

  @GetMapping("/addToCart/{id}")
  public String addToCart(@PathVariable Long id) {
    CartData.cart.add(productService.getProduct(id).get());
    return "redirect:/shop";
  }

  @GetMapping("/cart")
  public String cartGet(Model model) {
    model.addAttribute("cartCount", CartData.cart.size());
    model.addAttribute("total", CartData.cart.stream().mapToDouble(Product::getPrice).sum());
    model.addAttribute("cart", CartData.cart);
    return "cart";
  }

  @GetMapping("/cart/removeItem/{index}")
  public String cartRemove(@PathVariable Long index) {
    CartData.cart.remove(index);
    return "redirect:/cart";
  }

  @GetMapping("/checkout")
  public String checkout(Model model) {
    model.addAttribute("total", CartData.cart.stream().mapToDouble(Product::getPrice).sum());
    return "checkout";
  }
}
