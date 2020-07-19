package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepdefination extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String placeID;

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {

		APIResources resourceapi = APIResources.valueOf(resource);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceapi.getResource());

		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceapi.getResource());
		}
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} is {string}")
	public void is(String key, String value) {
		assertEquals(getJSonPath(response, key), value);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String resource) throws IOException {
		placeID = getJSonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", placeID);
		user_calls_with_post_http_request(resource, "GET");
		String name = getJSonPath(response, "name");
		assertEquals(name, ExpectedName);

	}

	@Given("DeletePlace playload")
	public void DeletePlace_playload() throws IOException {
		res =given().spec(requestSpecification()).body(data.deletePlace(placeID));
		
	}
}
