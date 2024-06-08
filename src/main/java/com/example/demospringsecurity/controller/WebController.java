package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.security.AuthenticationFacade;
import com.example.demospringsecurity.security.IsUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class WebController {
    private final AuthenticationFacade authenticationFacade;
    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    //@Secured("ROLE_USER")
    @IsUser
    @GetMapping("/user")
    public String getUsers(){
        return "user";
    }

    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
