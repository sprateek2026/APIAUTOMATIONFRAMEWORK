package com.api.test;

import Listners.TestListner;
import base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListner.class)
public class loginapitest {

@Test(description = "Verify if login api is working")
    public void logintest(){


    LoginRequest loginRequest = new LoginRequest("Prateek","$Rajvi99$");
    AuthService authservice = new AuthService();
    Response response  =authservice.login(loginRequest);

    LoginResponse loginResponse = response.as(LoginResponse.class);

    System.out.println(response.asPrettyString());

    System.out.println(loginResponse.getToken());

    Assert.assertEquals(loginResponse.getEmail(),"s.prateek2026@gmail.com");
    Assert.assertEquals(loginResponse.getId(),5399);


    }
}
