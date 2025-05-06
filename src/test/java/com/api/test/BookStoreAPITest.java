package com.api.test;

import com.api.base.BaseAPI;
import com.api.utils.APIUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class BookStoreAPITest {
    private int createdBookId;

    @Test(priority = 1)
    public void testCreateBook() {
        Map<String, Object> bookDetails = new HashMap<>();
        bookDetails.put("title", "Test Book");
        bookDetails.put("author", "Surya P");
        bookDetails.put("price", 19.99);

        Response response = APIUtils.createBook(bookDetails);
        response.then().statusCode(201);
        createdBookId = response.jsonPath().getInt("id");

        Assert.assertNotNull(createdBookId, "Book ID should not be null");
    }

    @Test(priority = 2)
    public void testGetBook() {
        Response response = APIUtils.getBook(createdBookId);
        response.then().statusCode(200);
        Assert.assertEquals(response.jsonPath().getString("title"), "Test Book");
    }

    @Test(priority = 3)
    public void testUpdateBook() {
        Map<String, Object> updatedDetails = new HashMap<>();
        updatedDetails.put("title", "Updated Test Book");
        updatedDetails.put("author", "Surya P");
        updatedDetails.put("price", 25.99);

        Response response = APIUtils.updateBook(createdBookId, updatedDetails);
        response.then().statusCode(200);
        Assert.assertEquals(response.jsonPath().getString("title"), "Updated Test Book");
    }

    @Test(priority = 4)
    public void testDeleteBook() {
        Response response = APIUtils.deleteBook(createdBookId);
        response.then().statusCode(204);
    }

}