package com.api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseAPI {
    protected String baseUrl;

    @BeforeClass
    public void setup() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
            baseUrl = properties.getProperty("base.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = baseUrl;
    }
}
