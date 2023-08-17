package stepDefinitions.api;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;

public class ApiSteps {
    private Response response;
    private RequestSpecification requestSpec;

    @Given("the endpoint is {string}")
    public void the_endpoint_is(String url) {
        String baseUrl = "https://reqres.in/api";
        baseURI = baseUrl + url;
    }

    @When("I send a {string} request")
    public void i_send_a_request(String http_method) throws Exception {
        HashMap data = new HashMap();
        switch (http_method) {
            case "GET":
                response = RestAssured.when().get(baseURI);
                break;
            case "POST":
                data.put("name", "Enrique");
                data.put("job", "QA Automation Engineer");
                response = RestAssured.given()
                            .contentType("application/json")
                            .body(data)
                        .when()
                            .post(baseURI);
                break;
            case "PUT":
                data.put("name", "Oingo");
                data.put("job", "Boingo");
                response = RestAssured.given()
                            .header("Content-Type", "application/json")
                            .body(data)
                        .when()
                            .put(baseURI);
                break;
            case "PATCH":
                data.put("name", "Oingo");
                data.put("job", "Boingo");
                response = RestAssured.given()
                            .contentType("application/json")
                            .body(data)
                        .when()
                            .patch(baseURI);
                break;
            case "DELETE":
                response = RestAssured.when().delete(baseURI);
                break;
            default:
                throw new Exception("HTTP method not implemented");
        }
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int code) {
        response.then().log().status();
        response.then().statusCode(code);
    }

    @Then("the get users body is valid")
    public void the_get_users_body_is_valid() {
        response.then()
                .log().body()
                .body("page", equalTo(1))
                .body("data[0].first_name", equalTo("George"));
    }

    @Then("the post user body is valid")
    public void the_post_user_body_is_valid() {
        response.then()
                .log().body()
                .body("name", equalTo("Enrique"))
                .body("job", equalTo("QA Automation Engineer"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Then("the get user body is valid")
    public void the_get_user_body_is_valid() {
        response.then()
                .log().body()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", startsWith("https://"));
    }

    @Then("the put user body is valid")
    public void the_put_user_body_is_valid() {
        response.then()
                .log().body()
                .body("name", equalTo("Oingo"))
                .body("job", equalTo("Boingo"))
                .body("updatedAt", notNullValue())
                .header("Content-Type", "application/json; charset=utf-8");
    }

    @Then("the patch user body is valid")
    public void the_patch_user_body_is_valid() {
        response.then()
                .log().body()
                .body("name", equalTo("Oingo"))
                .body("job", equalTo("Boingo"))
                .body("updatedAt", notNullValue());
    }
}
