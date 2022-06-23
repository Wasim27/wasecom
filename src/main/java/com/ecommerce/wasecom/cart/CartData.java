package com.ecommerce.wasecom.cart;

import com.ecommerce.wasecom.product.Product;
import java.util.ArrayList;
import java.util.List;

public class CartData {
  public static List<Product> cart;
  static {
    cart = new ArrayList<Product>();
  }

}
