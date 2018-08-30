package com.workspace.testproject.rest.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BaseSpringRequests {

    Logger logger = LoggerFactory.getLogger(BaseSpringRequests.class);

    public <T> ResponseEntity<T> getRequest(String url, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        logger.info(String.format("Sending GET request to: '%s'", url));
        return restTemplate.getForEntity(url, clazz);
    }

    public <T> ResponseEntity<T> postRequest(String url, HttpEntity<T> entity, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        logger.info(String.format("Sending POST request to: '%s'", url));
        return restTemplate.postForEntity(url, entity, clazz);
    }

    public <T> ResponseEntity<T> putRequest(String url, HttpEntity<T> entity, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        logger.info(String.format("Sending PUT request to: '%s'", url));
        return restTemplate.exchange(url, HttpMethod.PUT, entity, clazz);
    }
}
