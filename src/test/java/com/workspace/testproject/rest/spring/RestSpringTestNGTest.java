package com.workspace.testproject.rest.spring;

import com.workspace.testproject.BaseTestNGTest;
import com.workspace.testproject.rest.model.TodosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestSpringTestNGTest extends BaseTestNGTest {

    @Autowired
    private SpringRequestClient springRequestClient;

    @Test
    public void restGetTest() {
        ResponseEntity<TodosModel> response = springRequestClient.getDummy(TodosModel.class);
        Assert.assertEquals("1", response.getBody().getId());
        Assert.assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void restPostTest() {
        ResponseEntity<TodosModel> response = springRequestClient.postDummy();
        Assert.assertEquals("5", response.getBody().getUserId());
        Assert.assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void restPutTest() {
        ResponseEntity<TodosModel> response = springRequestClient.putDummy();
        Assert.assertEquals("7", response.getBody().getUserId());
        Assert.assertEquals(200, response.getStatusCodeValue());
    }
}
