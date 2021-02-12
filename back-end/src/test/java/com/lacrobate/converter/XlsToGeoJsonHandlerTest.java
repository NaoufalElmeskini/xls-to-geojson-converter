package com.lacrobate.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lacrobate.Main;
import com.lacrobate.model.output.umap.EmptyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Main.class})
class XlsToGeoJsonHandlerTest {
    @Autowired
    private XlsToGeoJsonHandler xlsToGeoJsonHandler;

    @Test
    public void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        EmptyObject emptyObject = new EmptyObject();
        try {
            String stringValue = objectMapper.writeValueAsString(emptyObject);
            assertEquals("{ }", stringValue);
        } catch (JsonProcessingException e) {
            fail("failed because of JsonProcessingException");
            e.printStackTrace();
        }
    }


}