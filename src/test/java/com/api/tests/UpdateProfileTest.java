package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UpdateProfileTest {
	
	@Test(description  = "Testing update profile API")
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("shabari13@gmail.com", "$Ganapa@13"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		UserManagementService ums = new UserManagementService();
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Shabari")
				.lastName("Shetty")
				.mobileNumber("5103048470")
				.email("shabari13@gmail.com").build();
		response = ums.updateProfile(profileRequest, loginResponse.getToken());
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
