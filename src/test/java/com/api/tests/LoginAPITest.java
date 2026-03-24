package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class LoginAPITest {
	@Test(description = "verify if login api is working")
	public void loginTest() {
		
		Response response = given()
							.baseUri("http://64.227.160.186:8080")
							.header("Content-Type", "application/json")
							.body("{ \"username\": \"shabari13@gmail.com\",\"password\": \"$Ganapa@13\"}")
							.post("/api/auth/login");
		System.out.println("response "+ response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
