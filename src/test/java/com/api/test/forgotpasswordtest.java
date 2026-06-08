package com.api.test;

import base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class forgotpasswordtest {

@Test(description = "Verify if forgot password api is working")
    public void forgotpassword(){



    AuthService authservice = new AuthService();
    Response response  =authservice.forgotpassword("dilips@gmail.com");

    System.out.println(response.asPrettyString());

}
}
