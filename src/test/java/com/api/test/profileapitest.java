package com.api.test;

import base.AuthService;
import base.UserManagement;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class profileapitest {

@Test(description = "Verify if login api is working")
    public void profiletest(){

    LoginRequest loginRequest = new LoginRequest("Prateek","$Rajvi99$");
    AuthService authservice = new AuthService();
    Response response  =authservice.login(loginRequest);
    LoginResponse loginResponse = response.as(LoginResponse.class);
    System.out.println(loginResponse.getToken());

    UserManagement userManagement = new UserManagement();
    response = userManagement.getprofile(loginResponse.getToken());

    System.out.println(response.asPrettyString());

    UserProfileResponse userProfileResponse =  response.as(UserProfileResponse.class);

    Assert.assertEquals(userProfileResponse.getId(),loginResponse.getId());

    //String token = loginResponse.getToken();
    //UserManagement userManagement = new UserManagement();
    //userManagement.profile(token);


    }
}
