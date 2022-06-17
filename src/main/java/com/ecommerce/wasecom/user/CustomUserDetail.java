package com.ecommerce.wasecom.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail extends User implements UserDetails {

  public CustomUserDetail(User user) {
    super(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorityList = new ArrayList<>();
    super.getRoles().forEach(role -> {
      authorityList.add(new SimpleGrantedAuthority(role.getName()));
    });
    return authorityList;
  }

  @Override
  public String getUsername() {
    return super.getEmail();
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

//  isAccountNonLocked()      = false , throw "User account is locked" exception
//  isEnabled()               = false , throw "User is disabled" exception
//  isAccountNonExpired()     = false , throw "User account has expired" exception
//  isCredentialsNonExpired() = false , throw "User credentials have expired" exception