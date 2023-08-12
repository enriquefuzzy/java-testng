package stepDefinitions.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

public class ApiSteps {
    private Response response;

    @Given("the endpoint is {string}")
    public void the_endpoint_is(String url) {
        String baseUrl = "https://reqres.in/api";
        baseURI = baseUrl + url;
    }

    @When("I send a {string} request")
    public void i_send_a_request(String http_method) throws Exception {
        switch (http_method) {
            case "GET":
                response = RestAssured.get(baseURI);
            case "POST":
                System.out.println("POST");
            default:
                throw new Exception("Invalid HTTP method");
        }
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int code) {
        response.then().log().status();
        response.then().statusCode(code);
    }

    @Then("the get users body is valid")
    public void the_get_users_body_is_valid() {
        response.then().log().body();
        response.then().body("page", equalTo(1));
        response.then().body("data[0].first_name", equalTo("George"));
    }
}
