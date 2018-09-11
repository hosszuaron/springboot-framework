package com.workspace.testproject.rest.spring;

import com.workspace.testproject.rest.model.TodosModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestSpringJunitTest {

    @Autowired
    private SpringRequestClient springRequestClient;

    @Test
    public void restGetTest() {
        ResponseEntity<TodosModel> response = springRequestClient.getDummy(TodosModel.class);
        assertEquals("1", response.getBody().getId());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void restPostTest() {
        ResponseEntity<TodosModel> response = springRequestClient.postDummy();
        assertEquals("5", response.getBody().getUserId());
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void restPutTest() {
        ResponseEntity<TodosModel> response = springRequestClient.putDummy();
        assertEquals("7", response.getBody().getUserId());
        assertEquals(200, response.getStatusCodeValue());
    }
}
