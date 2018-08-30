package com.workspace.testproject.rest.jersey;

import com.workspace.testproject.rest.model.TodosModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestJerseyTest {

    @Autowired
    private JerseyRequestClient requestClient;

    @Test
    public void jerseyGetTest() {
        Response response = requestClient.getDummy();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("1", response.readEntity(TodosModel.class).getId());
    }

    @Test
    public void jerseyPostTest() {
        Response response = requestClient.postDummy();
        Assert.assertEquals(201, response.getStatus());
        Assert.assertEquals("5", response.readEntity(TodosModel.class).getUserId());
    }

    @Test
    public void jerseyPutTest() {
        Response response = requestClient.putDummy();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("7", response.readEntity(TodosModel.class).getUserId());
    }
}