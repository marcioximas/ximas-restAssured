package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;
import static org.junit.Assert.*;

public class MyStepdefs {

    public int StatusCode;

    public RequestSpecification httpRequest;

    public Response response;

    public int ResponseCode;

    public ResponseBody body;

    public JSONObject requestParams;

    @Given("I have the base url for the api")
    public void iHaveTheBaseUrlForTheApi() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I send a GET request to the get all products api")
    public void i_send_a_get_request_to_the_get_all_products_api() {

        httpRequest = given();
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
        httpRequest = given();
        response = httpRequest.get("/products");

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
        RestAssured.baseURI = "http://fakestoreapi.com";
        httpRequest = given();
        requestParams = new JSONObject();



    }
    @When("I pass the request body of products {string}")
    public void i_pass_the_request_body_of_products(String title) {
        requestParams.put("title",title);
        requestParams.put("price",23.5);
        requestParams.put("description","The shoes perfect for your run!!");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toString());
        response = httpRequest.post("/products");
        body = response.getBody();

    }


    @Then("I receive the response body with id as {string}")
    public void iReceiveTheResponseBodyWithIdAs(String id) {
        JsonPath jsonPath = body.jsonPath();

        String s = jsonPath.get("id").toString();
        assertEquals(id,s);

    }

    @Given("I hit the url of put product api endpoint")
    public void iHitTheUrlOfPutProductApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url of products in the request with {string}")
    public void iPassTheUrlOfProductsInTheRequestWith(String productNumber) {
        httpRequest = given();
        requestParams.put("title","Test");
        requestParams.put("price",23.4);
        requestParams.put("description","The sshoes perfect for your run!!");
        requestParams.put("image","https://i.pravatar.ccc");
        requestParams.put("category","electroniccc");
        httpRequest.body(requestParams.toString());
        response = httpRequest.put("/products/"+ productNumber);
        body = response.getBody();

        JsonPath jsonPath = body.jsonPath();

        // s = jsonPath.get("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());



    }

    @And("I pass the request body of put api")
    public void iPassTheRequestBodyOfPutApi() {

    }
}
