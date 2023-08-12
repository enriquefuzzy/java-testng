import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

// Basic test for RestAssured, will be updated to be laid out better
public class ApiTest {
    //https://reqres.in/api/users
    String baseUrl = "https://reqres.in/api";
    @Test
    public void getUsers() {
        given()
        .when()
            .get(baseUrl + "/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data[0].first_name", equalTo("Michael"))
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

    @Test
    public void putUser() {
        JSONObject data = new JSONObject();
        data.put("name", "Oingo");
        data.put("job", "Boingo");

        given()
                .header("Content-Type", "application/json")
                .body(data.toString()) //Convert JSONobject to String
        .when()
                .put(baseUrl + "/users/2")
        .then()
                .statusCode(200)
                .body("name", equalTo("Oingo"))
                .body("job", equalTo("Boingo"))
                .body("updatedAt", notNullValue())
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test
    public void patchUser() {
        HashMap data = new HashMap();
        data.put("name", "Oingo");
        data.put("job", "Boingo");
        given()
                .contentType("application/json")
                .body(data)
        .when()
                .patch(baseUrl + "/users/2")
        .then()
                .statusCode(200)
                .body("name", equalTo("Oingo"))
                .body("job", equalTo("Boingo"))
                .body("updatedAt", notNullValue())
                .log().all();
    }

    @Test
    public void deleteUser() {
        when()
                .delete(baseUrl + "/users/3")
        .then()
                .statusCode(204)
                .log().all();
    }
}
