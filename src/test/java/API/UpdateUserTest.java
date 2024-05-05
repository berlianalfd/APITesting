package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest {
    String baseUrl = "https://dummyapi.io/data/v1/";
    String appId = "662df824f599018ef9e2e55e";
    String userId = "60d0fe4f5311236168a109dd";

    @Test //TC-3-7
    public void UpdateAllUserDataWithAppIdRegistered() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given()
                .header("app-id", appId)
                .header("Content-Type", "application/json");

        // Request body
        String requestBody = "{\"title\": \"mrs\"," +
                              "\"firstName\": \"Berliana\"," +
                              "\"lastName\": \"Syah\"," +
                              "\"gender\": \"female\"," +
                              "\"email\": \"berliansyah@example.com\"," +
                              "\"dateOfBirth\": \"1999-08-12\"," +
                              "\"phone\": \"+62826638927\"," +
                              "\"picture\": \"https://example.com/berlinpg\"," +
                              "\"location\": {" +
                                  "\"street\": \"Jl. supartman No. 123\"," +
                                  "\"city\": \"cimahi\"," +
                                  "\"state\": \"Jawa Barat\"," +
                                  "\"country\": \"Indonesia\"" +
                              "}}";

        // Request
        Response res = httpRequest.body(requestBody).put("/user/" + userId);

        // Verifikasi respons
        res.then().assertThat().statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"));
    }

     @Test //TC-3-8
    public void UpdateSomeUserDataWithAppIdRegistered() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given()
                .header("app-id", appId)
                .header("Content-Type", "application/json");
         
        // Request body
        String requestBody =
        "{\"firstName\": \"Berlin\"," +
        "\"lastName\": \"Syah\"," +
        "\"email\": \"berliansyah@example.com\"}";

        // Request
        Response res = httpRequest.body(requestBody).put("/user/" + userId);

        // Verifikasi respons
        res.then().assertThat().statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"));
    }

    @Test //TC-3-9
    public void UpdateAllUserDataWithoutEmailDataWithRegisteredAppId() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given()
                .header("app-id", appId)
                .header("Content-Type", "application/json");
         
        // Request body
        String requestBody ="{\"title\": \"mrs\"," +
                              "\"firstName\": \"yani\"," +
                              "\"lastName\": \"niniah\"," +
                              "\"gender\": \"female\"," +
                              "\"dateOfBirth\": \"1999-08-12\"," +
                              "\"phone\": \"+62826638927\"," +
                              "\"picture\": \"https://example.com/yaniiah.jpg\"," +
                              "\"location\": {" +
                                  "\"street\": \"Jl. supartman No. 123\"," +
                                  "\"city\": \"cimahi\"," +
                                  "\"state\": \"Jawa Barat\"," +
                                  "\"country\": \"Indonesia\"" +
                              "}}";

        // Request
        Response res = httpRequest.body(requestBody).put("/user/" + userId);

       // Verifikasi respons
        int statusCode = res.getStatusCode();
        System.out.println("The response code - " + statusCode);
        assertEquals("Expected status code 200", 200, statusCode);
    }

    @Test //TC-3-10
    public void UpdateSomeUserDataWithoutEmailDataWithRegisteredAppId() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given()
                .header("app-id", appId)
                .header("Content-Type", "application/json");
         
        // Request body
        String requestBody ="{\"firstName\": \"Berlin\"," +
                              "\"lastName\": \"Syah\"}";

        // Request
        Response res = httpRequest.body(requestBody).put("/user/" + userId);

       // Verifikasi respons
        int statusCode = res.getStatusCode();
        System.out.println("The response code - " + statusCode);
        assertEquals("Expected status code 200", 200, statusCode);
    }

    @Test //TC-3-11
    public void UpdateFirstNameInRange2to50WithRegisteredAppId() {
        // Setup
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given()
                .header("app-id", appId)
                .header("Content-Type", "application/json");
         
        // Request body
        String requestBody ="{\"firstName\": \"Berliana\"}";

        // Request
        Response res = httpRequest.body(requestBody).put("/user/" + userId);

       // Verifikasi respons
        int statusCode = res.getStatusCode();
        System.out.println("The response code - " + statusCode);
        assertEquals("Expected status code 200", 200, statusCode);
    }

}


   

   