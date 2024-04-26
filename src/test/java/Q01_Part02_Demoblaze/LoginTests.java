package Q01_Part02_Demoblaze;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

@Epic ("Rest Assured POC - Demoblaze.com Tests")
@Feature ("User Identity")
@Story ("User Login")
public class LoginTests {

    // private static String URL = "https://api.demoblaze.com/";
    // Base URL of the API
    private static final String BASE_URL = "https://api.demoblaze.com";

    @Test(description = "Valid Login Test")
    public void testValidLogin() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/login";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "username": "horacioss1",
            "password": "1234567890"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given().filter(new AllureRestAssured())
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains the Auth_token
        assert response.getBody().asString().contains("Auth_token");
    }
    
    @Test(description = "Login with a non-existing User name Test")
    public void testNonExistingUserName() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/login";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "username": "tesNonExistingUserName",
            "password": "1234567890"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given().filter(new AllureRestAssured())
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("User does not exist."));
    }

    @Test(description = "Login with a wrong password Test")
    public void testWrongPassword() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/login";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "username": "horacioss2",
            "password": "1234567890"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given().filter(new AllureRestAssured())
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("Wrong password."));
    }

    @Test(description = "Login with a missing user name Test")
    public void testMissingUserName() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/login";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "password": "1234567890"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given().filter(new AllureRestAssured())
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("Bad parameter, missing username"));
    }

    @Test(description = "Login with a missing password Test")
    public void testMissingPassword() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/login";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "username": "horacioss1"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given().filter(new AllureRestAssured())
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("Bad parameter, missing username"));
    }
}
