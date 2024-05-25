package com.exam.services.impl;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepo;
import com.exam.repo.UserRepo;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    //creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = userRepo.findByUsername(user.getUsername());

        if(local != null){

            System.out.println("User Already Exists");
            throw new Exception("User is already present");

        }else {
            //create user
            for(UserRole ur:userRoles){
                roleRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
                local =this.userRepo.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {

        User byUsername = userRepo.findByUsername(username);

        return byUsername;
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepo.deleteById(userId);
    }

    @Override
    public User updateUser(User user, long id) {
        user.setId(id);
        return userRepo.save(user);
    }
}
