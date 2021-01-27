package jm.security.example.controller;

import jm.security.example.hibernate.HibernateConfig;
import jm.security.example.model.User;
import jm.security.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ApplicationContext context =
            new AnnotationConfigApplicationContext(HibernateConfig.class);
    private UserService userService = context.getBean(UserService.class);

    @GetMapping
    public String getAdmin() {
        return "admin/admin";
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "admin/users";
    }

    @GetMapping(value = "/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/users/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping(value = "/users/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin/users";
    }

}
