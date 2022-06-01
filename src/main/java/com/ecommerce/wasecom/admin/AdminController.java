package com.ecommerce.wasecom.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AdminController {

  @GetMapping("/admin")
  public String indexPage(Model model) {
    model.addAttribute("admin", "Admin Home");
    return "adminHomepage";
  }
}