package com.workspace.testproject.rest.spring;

import com.workspace.testproject.rest.model.TodosModel;
import com.workspace.testproject.utils.PropertiesReader;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SpringRequestClient extends BaseSpringRequests {

    private final PropertiesReader propertiesReader;
    private final String server;

    public SpringRequestClient(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
        this.server=propertiesReader.getRestEndpoint();
    }

    public <T> ResponseEntity<T> getDummy(Class<T> clazz) {
        String url = String.format("%s/todos/1", server);
        ResponseEntity<T> response = getRequest(url, clazz);
        if (response.getStatusCodeValue() != 200) {
            logger.error(String.format("Error occurred during the HTTP request: '%s'", response.getStatusCodeValue()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s'",
                    response.getStatusCodeValue()));
        }
        return response;
    }

    public ResponseEntity<TodosModel> postDummy() {
        String url = String.format("%s/posts", server);
        HttpEntity<TodosModel> entity = new HttpEntity<>(new TodosModel("5"));
        ResponseEntity<TodosModel> response = postRequest(url, entity, TodosModel.class);
        if (response.getStatusCodeValue() != 201) {
            logger.error(String.format("Error occurred during the HTTP request: '%s'", response.getStatusCodeValue()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s'",
                    response.getStatusCodeValue()));
        }
        return response;
    }

    public ResponseEntity<TodosModel> putDummy() {
        String url = String.format("%s/posts/1", server);
        HttpEntity<TodosModel> entity = new HttpEntity<>(new TodosModel("7"));
        ResponseEntity<TodosModel> response = putRequest(url, entity, TodosModel.class);
        if (response.getStatusCodeValue() != 200) {
            logger.error(String.format("Error occurred during the HTTP request: '%s'", response.getStatusCodeValue()));
            throw new RuntimeException(String.format("Error occurred during the HTTP request: '%s'",
                    response.getStatusCodeValue()));
        }
        return response;
    }
}
