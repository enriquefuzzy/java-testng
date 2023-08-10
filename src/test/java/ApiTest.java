import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.HashMap;

// Basic test for RestAssured, will be updated to be laid out better
public class ApiTest {
    String baseUrl = "https://reqres.in/api";
    @Test
    public void getUsers() {
        //https://reqres.in/api/users
        given()
        .when()
            .get(baseUrl + "/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }

    @Test
    public void postUser() {
        HashMap data = new HashMap();
        data.put("name", "Enrique");
        data.put("job", "QA Automation Engineer");
        given()
                .contentType("application/json")
                .body(data)
        .when()
                .post(baseUrl + "/users")
        .then()
                .statusCode(201)
                .body("name", equalTo("Enrique"))
                .body("job", equalTo("QA Automation Engineer"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())
                .log().all();
    }

    @Test
    public void getUser() {
        when()
                .get(baseUrl + "/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", startsWith("https://"))
                .log().all();
    }
}
