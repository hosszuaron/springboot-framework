package com.workspace.testproject.rest.jersey;

import com.workspace.testproject.rest.model.TodosModel;
import com.workspace.testproject.utils.PropertiesReader;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class JerseyRequestClient extends BaseJerseyRequests {

    private final PropertiesReader propertiesReader;
    private final String server;

    public JerseyRequestClient(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
        this.server=propertiesReader.getRestEndpoint();
    }

    public Response getDummy() {
        String path = "todos/1";
        Response response =  getRequest(server, path);
        if (response.getStatus() != 200) {
            logger.error(String.format("Error occurred during the HTTP request: '%s - %s'", response.getStatus(),
                    response.getStatusInfo()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s - %s'",
                    response.getStatus(), response.getStatusInfo()));
        }
        return response;
    }

    public Response postDummy() {
        String path = "posts";
        TodosModel todosModel = new TodosModel("5");
        Entity input = Entity.entity(todosModel, MediaType.APPLICATION_JSON);
        Response response =  postRequest(server, path, input);
        if (response.getStatus() != 201) {
            logger.error(String.format("Error occurred during the HTTP request: '%s - %s'", response.getStatus(),
                    response.getStatusInfo()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s - %s'",
                    response.getStatus(), response.getStatusInfo()));
        }
        return response;
    }

    public Response putDummy() {
        String path = "posts/1";
        TodosModel todosModel = new TodosModel("7");
        Entity input = Entity.entity(todosModel, MediaType.APPLICATION_JSON);
        Response response =  putRequest(server, path, input);
        if (response.getStatus() != 200) {
            logger.error(String.format("Error occurred during the HTTP request: '%s - %s'", response.getStatus(),
                    response.getStatusInfo()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s - %s'",
                    response.getStatus(), response.getStatusInfo()));
        }
        return response;
    }
}