package jm.security.example.controller;

import jm.security.example.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("")
public class UserController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = a.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority auth : authorities) {
            roles.add(((Role) auth).getRole());
//            if (auth instanceof Role) {
//                roles.add(((Role) auth).getRole());
//            }
        }
        model.addAttribute("name", a.getName());
        model.addAttribute("roles", roles);
        return "user";
    }
}
