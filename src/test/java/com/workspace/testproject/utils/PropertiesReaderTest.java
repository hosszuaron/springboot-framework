package com.workspace.testproject.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesReaderTest {

    @Autowired
    private PropertiesReader propertiesReader;

    @Test
    public void propertiesReaderTest() {
        String email = propertiesReader.getEmail();
        assertEquals("aron.hosszu@accesa.eu", email);
    }
}
