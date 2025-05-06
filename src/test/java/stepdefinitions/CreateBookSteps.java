package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CreateBookSteps {
    private Response response;
    private Map<String, Object> payload = new HashMap<>();

    @Given("I have a valid book payload")
    public void i_have_a_valid_book_payload() {
        payload.put("title", "Test Book");
        payload.put("author", "surya P");
        payload.put("isbn", "1234567890123");
        payload.put("price", 9.99);
    }

    @When("I POST it to /books endpoint")
    public void i_post_it_to_books_endpoint() {
        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("http://localhost:8000/books");
    }

    @Then("I should receive status code {int}")
    public void i_should_receive_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("response should contain the book ID")
    public void response_should_contain_the_book_id() {
        response.then().body("id", notNullValue());
    }
}
