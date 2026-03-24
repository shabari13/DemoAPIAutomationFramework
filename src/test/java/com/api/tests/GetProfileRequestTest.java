package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInfoTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("shabari13@gmail.com", "$Ganapa@13"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("loginResponse "+ loginResponse.getToken());
		UserManagementService ums = new UserManagementService();
		response = ums.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
	}
}
