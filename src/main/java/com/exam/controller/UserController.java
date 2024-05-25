package com.exam.controller;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> userRoleSet = new HashSet<>();
        user.setProfile("default.png");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleSet.add(userRole);

        return this.userService.createUser(user, userRoleSet);

    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        User user = this.userService.getUser(username);
        return user;
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")long userId){
        userService.deleteUser(userId);

    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id")long id,@RequestBody User user){
        User user1 = userService.updateUser(user, id);
        return user1;
    }

}
