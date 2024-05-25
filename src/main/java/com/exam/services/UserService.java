package com.exam.services;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(long userId);

    public User updateUser(User user,long id);
}
