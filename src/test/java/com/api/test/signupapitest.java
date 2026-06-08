package com.api.test;

import base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class signupapitest {

@Test(description = "Verify if singup api is working")
    public void signuptest(){


    SignupRequest signupRequest = new SignupRequest("dilip","password@123","dilips@gmail.com","dilip","sharma","9257845211");
    AuthService authservice = new AuthService();
    Response response  =authservice.signup(signupRequest);

    Assert.assertEquals(response.statusCode(),200);
    Assert.assertEquals(response.asPrettyString(),"User registered successfully!");

}
}
