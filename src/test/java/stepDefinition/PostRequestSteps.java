package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




public class PostRequestSteps {

    @Given("^use post request for reqres endpoint$")
    public RequestSpecification use_post_request_for_reqres_endpoint() throws Throwable {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath= "/api/users";
        RequestSpecification req = RestAssured.given();
        req.header("Content-Type","application/json");
        return req;


    }

    @When("^send the response payload$")
    public Response send_the_response_payload() throws Throwable {
        JsonObject json = new JsonObject();
        json.addProperty("name","Tony Stark");
        json.addProperty("job","Ironman");

        String jsondata = json.toString();
        use_post_request_for_reqres_endpoint().body(jsondata);
        Response res = use_post_request_for_reqres_endpoint().request(Method.POST);
        return res;
    }

    @Then("^assert the status code$")
    public void assert_the_status_code() throws Throwable {

        int statusCode = send_the_response_payload().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);


    }

    @When("^send the json response payload$")
    public Response send_the_json_response_payload() throws Throwable {
        JsonObject json = new JsonObject();
        json.addProperty("name","Steve Rogers");
        json.addProperty("job","Captain America");

        String jsondata = json.toString();
        use_post_request_for_reqres_endpoint().body(jsondata);
        Response res = use_post_request_for_reqres_endpoint().request(Method.POST);
        return res;

    }

    @Then("^assert the response body$")
    public void assert_the_response_body() throws Throwable {

       String result = send_the_json_response_payload().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        System.out.println(result);



    }


}
