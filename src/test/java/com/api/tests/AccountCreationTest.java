package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description = "verify if signup api is working")
	public void signupTest() {
		SignUpRequest signupRequest = new SignUpRequest.Builder()
		.username("shabari1243456")
		.email("shabari43464@gmail.com")
		.firstName("Shabari")
		.lastName("shetty")
		.password("shabari12345")
		.mobileNumber("5103048474")
		.build();
		//SignUpRequest signupRequest = new SignUpRequest("shabari13@gmail.com", "$Ganapa@13");
		AuthService authService = new AuthService();
		Response response = authService.signup(signupRequest);
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}
}
