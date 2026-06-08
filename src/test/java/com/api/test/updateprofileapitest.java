package com.api.test;

import base.AuthService;
import base.UserManagement;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateUserProfileReuqest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class updateprofileapitest {

@Test(description = "Verify if profile update api is working")
    public void updateprofiletest(){

    LoginRequest loginRequest = new LoginRequest("Prateek","$Rajvi99$");
    AuthService authservice = new AuthService();
    Response response  =authservice.login(loginRequest);
    LoginResponse loginResponse = response.as(LoginResponse.class);
    System.out.println(loginResponse.getToken());

    UserManagement userManagement = new UserManagement();
    response = userManagement.getprofile(loginResponse.getToken());
    System.out.println(response.asPrettyString());

    UserProfileResponse userProfileResponse =  response.as(UserProfileResponse.class);
    Assert.assertEquals(userProfileResponse.getUsername(),loginResponse.getUsername());

    UpdateUserProfileReuqest updateUserProfileReuqest = new UpdateUserProfileReuqest("Prateeks","Sharma","s.prateek2026@gmail.com","8806041406");

    response = userManagement.updateprofile(updateUserProfileReuqest,loginResponse.getToken());
    System.out.println(response.asPrettyString());
    Assert.assertEquals(userProfileResponse.getFirstName(),"Prateeks");

    }
}
