package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static org.junit.Assert.*;

public class MyStepdefs {

    public int StatusCode;

    public RequestSpecification httpRequest;

    public Response response;

    public int ResponseCode;

    public ResponseBody body;

    @Given("I have the base url for the api")
    public void iHaveTheBaseUrlForTheApi() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I send a GET request to the get all products api")
    public void i_send_a_get_request_to_the_get_all_products_api() {

        httpRequest = RestAssured.given();
        response = httpRequest.get("/products");
    }


    @Then("I should get a response code {int}")
    public void iShouldGetAResponseCode(int arg0) {
        ResponseCode = response.getStatusCode();   // Write code here that turns the phrase above into concrete actions
        assertEquals(ResponseCode, 200);
    }

    @Given("I hit the url of get products api endpoint")
    public void iHitTheUrlOfGetProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void iPassTheUrlOfProductsInTheRequest() {
    //    httpRequest = RestAssured.given();
    //    response = httpRequest.get("/products");

    }

    @Then("I verify that the rate of the first product is {string}")
    public void iVerifyThatTheRateOfTheFirstProductIsFirstProductRate(String rate) {
        body = response.getBody();
        //convert response body to String
        String responseBody = body.asString();
        //JSON Representation from Response body
        JsonPath jsonPath = response.jsonPath();

        String s = jsonPath.getJsonObject("rating[0].rate").toString();

        assertEquals(rate,s);



    }


    @Given("I hit the url of post product api endpoint")
    public void iHitTheUrlOfPostProductApiEndpoint() {
      //  RestAssured.baseURL = "http://fakestoreapi.com";
     //   httpRequest = httpRequest.given();
      //  JSONObject requestParams = new JSONObject();
     //   requestParams.put()

    }
    @When("I pass the request body of products {string}")
    public void i_pass_the_request_body_of_products(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
