package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUser {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private static final String VALID_APP_ID = "662e2bdcbb70a769232593d6";
    private static final String USER_ID = "60d0fe4f5311236168a109dd";

    @Test
    public void testGetUserDataWithValidAppIdAndValidUserId() {
        // Setting base URL
        RestAssured.baseURI = BASE_URL;

        // Sending GET request with valid app-id and user id
        given()
            .header("app-id", VALID_APP_ID)
            .pathParam("id", USER_ID)
        .when()
            .get("/user/{id}")
        .then()
            .assertThat().statusCode(200) // Asserting status code is 200 OK
            .and().contentType(ContentType.JSON) // Asserting content type is JSON
            .and().body("id", equalTo(USER_ID)); // Asserting user id in response body
    }
}
