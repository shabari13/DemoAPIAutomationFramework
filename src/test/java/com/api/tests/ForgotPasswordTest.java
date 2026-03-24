package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test(description = "verify if forgot-password api is working")
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("shabarials@gmail.com");
		
		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		//Assert.assertEquals(response.statusCode(), 200);
	}
}
