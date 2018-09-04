package com.workspace.testproject.sql;

import com.workspace.testproject.sql.user.User;
import com.workspace.testproject.sql.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testDeTest() {

        User user = new User();
        user.setName("Johnny Rotten");
        user.setEmail("johnny@rotten.com");
        long id = userService.createUser(user);

        List<User> allUsers = userService.getAllUsers();
        List<String> allUserNames = allUsers.stream().map(usr -> usr.getName()).collect(Collectors.toList());

        userService.deleteUserById(id);
        Assert.assertTrue(allUserNames.contains("Johnny Rotten"));
    }
}
