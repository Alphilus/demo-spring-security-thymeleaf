package com.example.demospringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] paths = {"/phim-le", "/phim-bo", "/phim-chieu-rap", "/tin-tuc/**"};

        //Cấu hình paths
        http.authorizeHttpRequests(auth ->{
            // Public access
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers("/css/**", "/js/**", "/image/**").permitAll();

            // Role-based access control
            auth.requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/users/**").hasRole("ADMIN");
            auth.requestMatchers("/categories/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/products/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/brands/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/orders/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/posts/**").hasAnyRole("ADMIN", "SALE", "AUTHOR");
            auth.requestMatchers("/profile/**").hasRole("USER");

            // Any other request requires authentication
            auth.anyRequest().authenticated();
        });

        //Cấu hình login
        http.formLogin(formLogin -> {
            formLogin.loginPage("/login"); // Trang login do mình thiết kế
            formLogin.defaultSuccessUrl("/", true); // Nếu login thành công thì chuyển hướng về trang chủ
            formLogin.loginProcessingUrl("/login-handle");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("pass");
            formLogin.permitAll(); // Tất cả đều được truy cập vào trang login
        });

        //Cấu hình logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/"); // Nếu logout thành công thì chuyển hướng về trang chủ
            logout.deleteCookies("JSESSIONID"); // Xóa cookie
            logout.invalidateHttpSession(true); // Hủy session
            logout.clearAuthentication(true); // Xóa thông tin xác thực
            logout.permitAll(); // Tất cả đều được truy cập vào trang logout
        });

        return http.build();
    }
}
