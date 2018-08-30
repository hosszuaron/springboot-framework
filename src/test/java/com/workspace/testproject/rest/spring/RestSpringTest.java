package com.workspace.testproject.rest.spring;

import com.workspace.testproject.rest.model.TodosModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestSpringTest {

    @Autowired
    private SpringRequestClient springRequestClient;

    @Test
    public void springRestTest() {
        ResponseEntity<TodosModel> response = springRequestClient.getDummy(TodosModel.class);
        Assert.assertEquals("1", response.getBody().getId());
        Assert.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void postRestTest() {
        ResponseEntity<TodosModel> response = springRequestClient.postDummy();
        Assert.assertEquals("5", response.getBody().getUserId());
        Assert.assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void putRestTest() {
        ResponseEntity<TodosModel> response = springRequestClient.putDummy();
        Assert.assertEquals("7", response.getBody().getUserId());
        Assert.assertEquals(200, response.getStatusCodeValue());
    }
}
