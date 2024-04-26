package Q01_Part01_PetStore;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic ("petstore Tests")
@Feature ("Pets APIs")
@Story ("Pets CRUD operations")
public class PetStoreAPITests {

    @BeforeClass
    public void setup() {
        // Set the base URI for the Pet Store API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    // Test creating a new pet using the POST method
    @Test(description = "Create new Pet")
    public void createNewPet() {
        // Create request specification
        RequestSpecification request = RestAssured.given();
        // Set content type to JSON
        request.header("Content-Type", "application/json");
        // Define the request body
        String body = "{ \"id\": 12345, \"name\": \"Fido\", \"status\": \"available\" }";
        // Set the request body
        request.body(body);
        // Send the POST request
        Response response = request.post("/pet");
        // Assert that the response status code is 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);
        // Add more assertions based on expected response (e.g., response body validation)
    }

    // Test retrieving the details of a pet using the GET method
    @Test(description = "get Pet by Id", dependsOnMethods = "createNewPet")
    public void getPetById() {
        // Create request specification
        RequestSpecification request = RestAssured.given();
        // Send the GET request
        Response response = request.get("/pet/12345");
        // Assert that the response status code is 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);
        // Add more assertions based on expected response (e.g., response body validation)
    }

    // Test updating a pet using the PUT method
    @Test(description = "Update Pet data by Id", dependsOnMethods = "getPetById")
    public void updatePet() {
        // Create request specification
        RequestSpecification request = RestAssured.given();
        // Set content type to JSON
        request.header("Content-Type", "application/json");
        // Define the request body
        String body = "{ \"id\": 12345, \"name\": \"Buddy\", \"status\": \"sold\" }";
        // Set the request body
        request.body(body);
        // Send the PUT request
        Response response = request.put("/pet");
        // Assert that the response status code is 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);
        // Add more assertions based on expected response (e.g., response body validation)
    }

    // Test deleting a pet using the DELETE method
    @Test(description = "Delete Pet by Id", dependsOnMethods = "updatePet")
    public void deletePet() {
        // Create request specification
        RequestSpecification request = RestAssured.given();
        // Send the DELETE request
        Response response = request.delete("/pet/12345");
        // Assert that the response status code is 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);
        // Add more assertions based on expected response (e.g., response body validation)
    }
}