package API;
import io.restassured.RestAssured;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;

public class GetUserTest {
    
    @Test //TC-2-1 
    public void tc1GetUserDataWithoutAppIdAndValidUserId() {
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109dd"; // id user terdaftar
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .get(endpoint);
        int statusCode = response.getStatusCode();
        try {
            assertEquals("Expected status code 403 Forbidden", 403, statusCode);
        } catch (AssertionError e) {
            System.out.println("Actual status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());
            throw e;
        }
        String responseBody = response.getBody().asString();
        assertEquals("Expected error message", "{\"error\":\"APP_ID_MISSING\"}", responseBody);
    }
    
    @Test //TC-2-2
    public void tc2GetUserDataWithoutAppIdAndInvalidUserId() {
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .get(endpoint);
        int statusCode = response.getStatusCode();
        try {
            assertEquals("Expected status code 403 Forbidden", 403, statusCode);
        } catch (AssertionError e) {
            System.out.println("Actual status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());
            throw e;
        }
        String responseBody = response.getBody().asString();
        assertEquals("Expected error message", "{\"error\":\"APP_ID_MISSING\"}", responseBody);
    }
    
    @Test //TC-2-3
    public void tc3GetUserDataWithInvalidAppId() {
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109dd"; // id user terdaftar
        String invalidAppId = "662e2bdcbb70a769232593d7"; // app-id yang salah
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", invalidAppId)
                .get(endpoint);
        int statusCode = response.getStatusCode();
        try {
            assertEquals("Expected status code 403 Forbidden", 403, statusCode);
        } catch (AssertionError e) {
            System.out.println("Actual status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());
            throw e;
        }
        String responseBody = response.getBody().asString();
        assertEquals("Expected error message", "{\"error\":\"APP_ID_NOT_EXIST\"}", responseBody);
    }
    
    @Test //TC-2-4
    public void tc4GetUserDataWithInvalidUserIdAndAppId() {
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar
        String appId = "662e2bdcbb70a769232593d7"; //app-id yang salah
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .get(endpoint);
        int statusCode = response.getStatusCode();
        try {
            assertEquals("Expected status code 403 Forbidden", 403, statusCode);
        } catch (AssertionError e) {
            System.out.println("Actual status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());
            throw e;
        }
        String responseBody = response.getBody().asString();
        assertEquals("Expected error message", "{\"error\":\"APP_ID_NOT_EXIST\"}", responseBody);
    }

    @Test //TC-2-6
    public void tc6GetUserDataWithInvalidUserId() {
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar
        String appId = "662e2bdcbb70a769232593d6"; //app-id yang valid
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .get(endpoint);
        int statusCode = response.getStatusCode();
        try {
            assertEquals("Expected status code 404 Not Found", 404, statusCode);
        } catch (AssertionError e) {
            System.out.println("Actual status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());
            throw e;
        }
        String responseBody = response.getBody().asString();
        assertEquals("Expected error message", "{\"error\":\"RESOURCE_NOT_FOUND\"}", responseBody);
    }

}
