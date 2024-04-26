package Q01_Part02_Demoblaze;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import org.testng.annotations.Test;


@Epic ("Rest Assured POC - Demoblaze.com Tests")
@Feature ("User Identity")
@Story ("User Sign Up")
public class SignUpTests {

    // private static String URL = "https://api.demoblaze.com/";
    // Base URL of the API
    private static final String BASE_URL = "https://api.demoblaze.com";

    @Test(description = "successful User Sign Up")
    public void testSuccessfulSignUp() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/signup";

        // Generate the current date and time as a string
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String currentDateTime = now.format(formatter);

        // Create the username with the current date and time
        String username = "user" + currentDateTime;

        // Define the request body as a JSON object
        String requestBody = String.format("""
        {
            "username": "%s",
            "password": "1234567890"
        }
        """, username);

        // Send a POST request to the API endpoint with the request body
        Response response = given()
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body is an empty string
        assert response.getBody().asString().contains("errorMessage") == false;
    }

    @Test(description = "Sign Up with an existing user name")
    public void testSignUpWithExistingUsername() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/signup";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "username": "newUser",
            "password": "123456789"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given()
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("This user already exist."));
    }

    @Test(description = "Sign Up with out sending user name")
    public void testSignUpWithoutUsername() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/signup";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "password": "123456789"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given()
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("Bad parameter, missing username or password"));
    }

    @Test(description = "Sign Up without sending passwoed")
    public void testSignUpWithoutPassword() {
        // Define the API endpoint
        String apiUri = BASE_URL + "/signup";

        // Define the request body as a JSON object
        String requestBody = """
        {
            "password": "123456789"
        }
        """;

        // Send a POST request to the API endpoint with the request body
        Response response = given()
            .contentType("application/json") // Specify the content type as JSON
            .body(requestBody) // Set the request body
            .when()
            .post(apiUri);

        // Assert that the response status code is 200 OK
        response.then()
            .statusCode(200);

        // Assert that the response body contains error message "User already exist"
        response.then()
            .body("errorMessage", equalTo("Bad parameter, missing username or password"));
    }

}
