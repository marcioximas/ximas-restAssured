package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class MyStepdefs {
    @Given("I have the base url for the api")
    public void iHaveTheBaseUrlForTheApi() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I send a GET request to the get all products api")
    public void i_send_a_get_request_to_the_get_all_products_api() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/products");
        int ResponseCode = response.getStatusCode();
    }
     @Then("I should get a response code")
    public void iShouldGetAResponseCode() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/products");
        int ResponseCode = response.getStatusCode();   // Write code here that turns the phrase above into concrete actions
        assertEquals(ResponseCode, 200);
    }
}
