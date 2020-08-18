package stepDefinition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;





public class GetRequestSteps {


    @Given("^i use reqres get endpoint$")
    public RequestSpecification i_use_reqres_get_endpoint() throws Throwable {
        RestAssured.baseURI = "https://reqres.in/";
        String endURL = "/api/users?page=2";
        RequestSpecification req = RestAssured.given();
        return req;

    }

    @When("^submit get request$")
    public Response submit_get_request() throws Throwable {

        Response res = i_use_reqres_get_endpoint().request(Method.GET);
        String jsonPayload = res.asString();
        System.out.println("headers" +res.getHeaders());

        return res;
    }

    @Then("^get status code$")
    public void get_status_code() throws Throwable {

        int statusCode = submit_get_request().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);

    }
    @Then("^assert the response body email$")
    public void assert_the_response_body_email() throws Throwable {
        String result = submit_get_request().body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
       // JsonNode jsonNode = objectMapper.readTree(result);
      //  System.out.println(result);
        //String email = jsonNode.get("data").get(1).get("email").asText();
       // Assert.assertEquals(email, "lindsay.ferguson@reqres.in");

    }

    @Then("^assert the response body firstname$")
    public void assert_the_response_body_firstname() throws Throwable {
        String result = submit_get_request().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(result);
        String firstname = jsonNode.get("data").get(3).get("first_name").asText();
        Assert.assertEquals(firstname,"Byron");
    }



}
