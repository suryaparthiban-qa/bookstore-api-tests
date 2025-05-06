package com.api.utils;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class APIUtils {
    public static Response createBook(Map<String, Object> bookDetails) {
        return given()
                .contentType(ContentType.JSON)
                .body(bookDetails)
                .when()
                .post(EndPoints.CREATE_BOOK);
    }

    public static Response getBook(int bookId) {
        return given()
                .pathParam("id", bookId)
                .when()
                .get(EndPoints.GET_BOOK);
    }

    public static Response updateBook(int bookId, Map<String, Object> bookDetails) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("id", bookId)
                .body(bookDetails)
                .when()
                .put(EndPoints.UPDATE_BOOK);
    }

    public static Response deleteBook(int bookId) {
        return given()
                .pathParam("id", bookId)
                .when()
                .delete(EndPoints.DELETE_BOOK);
    }
}
