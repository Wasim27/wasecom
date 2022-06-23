package com.ecommerce.wasecom.configs;

import com.ecommerce.wasecom.user.CustomUserDetail;
import com.ecommerce.wasecom.user.CustomUserDetailService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired
  GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
  @Autowired
  CustomUserDetailService customUserDetailService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "/shop/**", "/forgotpassword",
            "/register").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN").anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .failureUrl("/login?error= true")
        .defaultSuccessUrl("/admin")
        .usernameParameter("email")
        .passwordParameter("password")
        .and()
        .oauth2Login()
        .loginPage("/login")
        .successHandler(googleOAuth2SuccessHandler)
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("logout"))
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .and()
        .exceptionHandling()
        .and()
        .csrf()
        .disable();
    http.headers().frameOptions().disable();

    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//    return (AuthenticationManager) auth.userDetailsService(customUserDetailService);
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
    return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**", "/js/**");
  }
}
