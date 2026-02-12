package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApiClient {

    static {
        RestAssured.baseURI = "https://reqres.in";
    }

    public static long login() {

        String body = """
        {
          "email": "eve.holt@reqres.in",
          "password": "cityslicka"
        }
        """;

        long start = System.currentTimeMillis();

        Response response =
                given()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post("/api/login");

        long duration = System.currentTimeMillis() - start;

        return duration;
    }
}
