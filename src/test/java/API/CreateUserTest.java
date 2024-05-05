package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;

public class CreateUserTest {
    
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    //TC-1-1
    @Test
    public void testCreateUserTanpaMenggunakanAppId() {
        String requestBody = "{\n" +
                                "  \"firstName\": \"Alina\",\n" +
                                "  \"lastName\": \"Asfika\",\n" +
                                "  \"email\": \"alfika@example.com\",\n" +
                                "}";

        Response response = given()
                .body(requestBody)
                .post("/user/create");

        // Memeriksa status response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(403, statusCode);

        // Memeriksa response body
        String responseBody = response.getBody().path("error");
        Assert.assertEquals("APP_ID_MISSING", responseBody);
    }

    // TC-1-8
    @Test
    public void testCreateUserValidData() {
        String requestBody = "{\n" +
                                "  \"title\": \"mrs\",\n" +
                                "  \"firstName\": \"Zizah\",\n" +
                                "  \"lastName\": \"Natania\",\n" +
                                "  \"gender\": \"female\",\n" +
                                "  \"email\": \"zaazisi@example.com\",\n" +
                                "  \"dateOfBirth\": \"1988-05-15T00:00:00.000Z\",\n" +
                                "  \"phone\": \"081234576543\",\n" +
                                "  \"picture\": \"https://example.com/zizah.jpg\",\n" +
                                "  \"location\": {\n" +
                                "    \"street\": \"123 Main Street\",\n" +
                                "    \"city\": \"New York\",\n" +
                                "    \"state\": \"New York\",\n" +
                                "    \"country\": \"United States\",\n" +
                                "    \"timezone\": \"-8:00\"\n" +
                                "  }\n" +
                                "}";

        Response response = given()
                .header("app-id", "662df82df599010259e2e561")  
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/user/create");
        
        // Memeriksa status response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        
        // Memeriksa response body
        response.then()
            .body("title", Matchers.equalTo("mrs"))
            .body("firstName", Matchers.equalTo("Zizah"))
            .body("lastName", Matchers.equalTo("Natania"))
            .body("gender", Matchers.equalTo("female"))
            .body("email", Matchers.equalTo("zaazisi@example.com"))
            .body("dateOfBirth", Matchers.equalTo("1988-05-15T00:00:00.000Z"))
            .body("phone", Matchers.equalTo("081234576543"))
            .body("picture", Matchers.equalTo("https://example.com/zizah.jpg"))
            .body("location.street", Matchers.equalTo("123 Main Street"))
            .body("location.city", Matchers.equalTo("New York"))
            .body("location.state", Matchers.equalTo("New York"))
            .body("location.country", Matchers.equalTo("United States"))
            .body("location.timezone", Matchers.equalTo("-8:00"));
    }

    //TC-1-9 
    @Test
    public void testCreateUserMenggunakanEmailTerdaftar() {
        String requestBody = "{\n" +
                                "  \"title\": \"mrs\",\n" +
                                "  \"firstName\": \"Zizah\",\n" +
                                "  \"lastName\": \"Natania\",\n" +
                                "  \"gender\": \"female\",\n" +
                                "  \"email\": \"zizania@example.com\",\n" +
                                "  \"dateOfBirth\": \"1988-05-15T00:00:00.000Z\",\n" +
                                "  \"phone\": \"081234576543\",\n" +
                                "  \"picture\": \"https://example.com/zizah.jpg\",\n" +
                                "  \"location\": {\n" +
                                "    \"street\": \"123 Main Street\",\n" +
                                "    \"city\": \"New York\",\n" +
                                "    \"state\": \"New York\",\n" +
                                "    \"country\": \"United States\",\n" +
                                "    \"timezone\": \"-8:00\"\n" +
                                "  }\n" +
                                "}";

        Response response = given()
                .header("app-id", "662df82df599010259e2e561")
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/user/create");

        // Memeriksa status response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(400, statusCode);
        
        // Memeriksa response body
        String responseBody = response.getBody().path("error");
        Assert.assertEquals("BODY_NOT_VALID", responseBody);
    }

    // TC-1-10
    @Test
    public void testCreateUserDenganMengosongkanTitle() {
        String requestBody = "{\n" +
                                "  \"title\": \" \",\n" +
                                "  \"firstName\": \"Cintia\",\n" +
                                "  \"lastName\": \"Ningsih\",\n" +
                                "  \"gender\": \"female\",\n" +
                                "  \"email\": \"Cining@example.com\",\n" +
                                "  \"dateOfBirth\": \"2003-01-20T00:00:00.000Z\",\n" +
                                "  \"phone\": \"081234575000\",\n" +
                                "  \"picture\": \"https://example.com/zizah.jpg\",\n" +
                                "  \"location\": {\n" +
                                "    \"street\": \"123 Main Street\",\n" +
                                "    \"city\": \"Bandung\",\n" +
                                "    \"state\": \"Jawa Barat\",\n" +
                                "    \"country\": \"Indonesia\",\n" +
                                "    \"timezone\": \"-15:40\"\n" +
                                "  }\n" +
                                "}";

        Response response = given()
                .header("app-id", "662df82df599010259e2e561")
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/user/create");
        
        // Memeriksa status response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(400, statusCode);
          
        // Memeriksa response body
        String responseBody = response.getBody().path("error");
        Assert.assertEquals("BODY_NOT_VALID", responseBody);
    }

    // TC-1-40
    @Test
    public void testCreateUserInvalidFormatLocationStreet() {
        String requestBody = "{\n" +
                                "  \"title\": \"mrs\",\n" +
                                "  \"firstName\": \"Cintia\",\n" +
                                "  \"lastName\": \"Ningsih\",\n" +
                                "  \"gender\": \"female\",\n" +
                                "  \"email\": \"CintiaNsh@example.com\",\n" +
                                "  \"dateOfBirth\": \"2003-01-20T00:00:00.000Z\",\n" +
                                "  \"phone\": \"081234575000\",\n" +
                                "  \"picture\": \"https://example.com/zizah.jpg\",\n" +
                                "  \"location\": {\n" +
                                "    \"street\": \"ciwa\",\n" +
                                "    \"city\": \"Bandung\",\n" +
                                "    \"state\": \"Jawa Barat\",\n" +
                                "    \"country\": \"Indonesia\",\n" +
                                "    \"timezone\": \"-15:40\"\n" +
                                "  }\n" +
                                "}";

        Response response = given()
                .header("app-id", "662df82df599010259e2e561")
                .body(requestBody)
                .contentType(ContentType.JSON)
                .post("/user/create");
        
        // Memeriksa status response
        int statusCode = response.getStatusCode();
        Assert.assertEquals(400, statusCode);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertEquals("BODY_NOT_VALID", responseBody);   
    }
}
