package jm.security.example;

import jm.security.example.dao.RoleDao;
import jm.security.example.dao.UserDao;
import jm.security.example.hibernate.HibernateConfig;
import jm.security.example.model.Role;
import jm.security.example.model.User;
import jm.security.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserService userService = context.getBean(UserService.class);
        RoleDao roleDao = context.getBean(RoleDao.class);

        User user = userService.getUserById(1L);
        System.out.println("Username: " + user.getName());
        System.out.println("Password: " + user.getPassword());

        User user1 = userService.getUserByName("user");
        System.out.println("Username: " + user1.getName());
        System.out.println("Password: " + user1.getPassword());

        Role role = roleDao.getRoleById(1L);
        System.out.println("Role: " + role.getRole());

//        User user2 = new User();
//        Set<Role> roles = new HashSet<Role>();
//        roles.add(roleDao.getRoleById(1L));
//        user2.setRoles(roles);
//        user2.setName("max");
//        user2.setPassword("max");
//        userService.add(user2);
    }
}
