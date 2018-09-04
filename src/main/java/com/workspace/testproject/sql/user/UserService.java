package com.workspace.testproject.sql.user;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    long createUser(User user);

    void deleteUserById(long id);
}
