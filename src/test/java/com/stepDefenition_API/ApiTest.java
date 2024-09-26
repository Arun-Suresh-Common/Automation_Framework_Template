package com.stepDefenition_API;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects_API.ApiBody;

public class ApiTest {

	public static String jsonstring;
	public static String token;
	RequestSpecification request;
	Response response;
	ApiBody apibody;

	@Given("I am an authorized user")
	public void i_am_an_authorized_user() throws Exception {

		apibody=new ApiBody();
		RestAssured.baseURI=apibody.getBaseUrl();
		request=RestAssured.given().contentType(ContentType.JSON)
				.header("Content-Type","application/json");
		response=request.body(apibody.authtokenbody()).post("/Account/v1/GenerateToken");
		//response.then().log().all();
		jsonstring=response.asString();
		token=JsonPath.from(jsonstring).getString("token");
		System.out.println("token value"+token);

	}

	@Given("A list of books are available")
	public void a_list_of_books_are_available() throws Exception {
		
		RestAssured.baseURI=apibody.getBaseUrl();
		request=RestAssured.given().contentType(ContentType.JSON)
				.header("Content-Type","application/json");
		response=request.get("/BookStore/v1/Books");
		response.then().log().all();
		
		jsonstring=response.asString();
		List<Map<String, String>> books =JsonPath.from(jsonstring).get("books");
		String BookID=books.get(0).get("isbn");
		System.out.println(BookID);
	}

	@Then("the book is added")
	public void the_book_is_added() throws Exception {
		
		RestAssured.baseURI=apibody.getBaseUrl();
		request=RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.header("Content-Type","application/json");
		response=request.body(apibody.addBookBody()).post("/BookStore/v1/Books");
		response.then().log().all();
		//jsonstring=response.asString();
		Assert.assertEquals(200, response.getStatusCode());

	}

	@Then("the book is removed")
	public void the_book_is_removed() {

	}


}
