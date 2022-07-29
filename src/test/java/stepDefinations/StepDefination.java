package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	ResponseSpecification re;
	RequestSpecification res;
	Response response;
	TestDataBuild data1 = new TestDataBuild();
	static String place_id;
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address)  throws IOException {
		 re = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 res = given().spec(requestSpecification()).body(data1.addPlacePayload(name, language, address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) { 
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(httpMethod.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	    
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions

	    assertEquals(getJsonPath(response, keyValue),Expectedvalue);
	    
	}
	
	@Then("Verify palce ID is created maps to {string} using {string}")
	public void verify_palce_id_is_created_maps_to_using(String ExpectedName, String resource) throws IOException {
	    place_id = getJsonPath(response, "place_id");
	    res=given().spec(requestSpecification()).queryParam("place_id", place_id);
	    user_calls_with_http_request(resource,"GET");
	    String name=getJsonPath(response, "name");
	    assertEquals(name,ExpectedName);
	    
	}

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    res =given().spec(requestSpecification()).body(data1.deletePlacepayloadd(place_id));
	
	}

}
