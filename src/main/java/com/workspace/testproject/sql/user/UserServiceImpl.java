package com.workspace.testproject.sql.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public long createUser(User user) {
        User usr = userRepository.save(user);
        return usr.getId();
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
