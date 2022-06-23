package com.ecommerce.wasecom.login;

import com.ecommerce.wasecom.cart.CartData;
import com.ecommerce.wasecom.user.Role;
import com.ecommerce.wasecom.user.RoleRepository;
import com.ecommerce.wasecom.user.User;
import com.ecommerce.wasecom.user.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;

  @GetMapping("/login")
  public String login() {
    CartData.cart.clear();
    return "login";
  }

  @GetMapping("/register")
  public String registerGet() {
    return "register";
  }

  @PostMapping("/register")
  public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
    String password = user.getPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));
    List<Role> roles = new ArrayList<>();
    roles.add(roleRepository.findById(2).get());
    user.setRoles(roles);
    userRepository.save(user);
    request.login(user.getEmail(), password);
    return "redirect:/";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/home";
  }
}
