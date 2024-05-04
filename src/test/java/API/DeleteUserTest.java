package API;
import io.restassured.RestAssured;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import io.restassured.response.Response;



public class DeleteUserTest {

    @Test //TC-4-1
    public void tc1DeleteUserWithValidUserIdAndWithoutAppId() {
        // Definisikan base URL, endpoint, dan app-id
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a10a03"; // id user terdaftar

        // Kirimkan request DELETE dengan headers yang ditentukan
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .delete(endpoint);

        // Memeriksa status code
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 403 Forbidden", 403, statusCode);

        // Memeriksa apakah response body adalah JSON dengan pesan error yang sesuai
        String responseBody = response.getBody().asString();
        assertTrue("Response body is not a JSON", responseBody.contains("\"error\":\"APP_ID_MISSING\""));
    }

    @Test //TC-4-2
    public void tc2DeleteUserWithInvalidUserIdAndWithoutAppId() {
        // Definisikan base URL, endpoint, dan app-id
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar

        // Kirimkan request DELETE dengan headers yang ditentukan
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .delete(endpoint);

        // Memeriksa status code
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 403 Forbidden", 403, statusCode);

        // Memeriksa apakah response body adalah JSON dengan pesan error yang sesuai
        String responseBody = response.getBody().asString();
        assertTrue("Response body is not a JSON", responseBody.contains("\"error\":\"APP_ID_MISSING\""));
    }

    @Test //TC-4-3
    public void tc3DeleteUserWithValidUserIdAndInvalidAppId() {
        // Definisikan base URL, endpoint, dan app-id
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a10a03"; // id user terdaftar
        String appId = "662e2bdcbb70a769232593d7"; // app-id yang salah


        // Kirimkan request DELETE dengan headers yang ditentukan
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .delete(endpoint);

        // Memeriksa status code
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 403 Forbidden", 403, statusCode);

        // Memeriksa apakah response body adalah JSON dengan pesan error yang sesuai
        String responseBody = response.getBody().asString();
        assertTrue("Response body is not a JSON", responseBody.contains("\"error\":\"APP_ID_NOT_EXIST\""));
    }

    @Test //TC-4-4
    public void tc4DeleteUserWithInvalidUserIdAndInvalidAppId() {
        // Definisikan base URL, endpoint, dan app-id
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar
        String appId = "662e2bdcbb70a769232593d7"; // app-id yang salah


        // Kirimkan request DELETE dengan headers yang ditentukan
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .delete(endpoint);

        // Memeriksa status code
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 403 Forbidden", 403, statusCode);

        // Memeriksa apakah response body adalah JSON dengan pesan error yang sesuai
        String responseBody = response.getBody().asString();
        assertTrue("Response body is not a JSON", responseBody.contains("\"error\":\"APP_ID_NOT_EXIST\""));
    }

    @Test //TC-4-6
    public void tc6DeleteUserWithInvalidUserId() {
        // Definisikan base URL, endpoint, dan app-id
        String baseUrl = "https://dummyapi.io/data/v1/";
        String endpoint = "/user/60d0fe4f5311236168a109KK"; // id user tidak terdaftar
        String appId = "662e2bdcbb70a769232593d6"; // app-id yang benar

        // Kirimkan request DELETE dengan headers yang ditentukan
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .header("app-id", appId)
                .delete(endpoint);

        // Memeriksa status code
        int statusCode = response.getStatusCode();
        assertEquals("Expected status code 404 Not Found", 404, statusCode);

        // Memeriksa apakah response body adalah JSON dengan pesan error yang sesuai
        String responseBody = response.getBody().asString();
        assertTrue("Response body is not a JSON", responseBody.contains("\"error\":\"RESOURCE_NOT_FOUND\""));
    }

}
