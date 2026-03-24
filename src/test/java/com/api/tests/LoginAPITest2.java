package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {
	@Test(description = "verify if login api is working")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("shabari13@gmail.com", "$Ganapa@13");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "shabari13@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 4764);
	}
}
