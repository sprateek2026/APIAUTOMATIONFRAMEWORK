package base;

import io.restassured.response.Response;

import java.util.HashMap;

public class UserManagement extends BaseService {


    private static final String BASE_PATH ="/api/users";


    public Response getprofile(String token){

        setauthtoken(token);
        return getRequest(BASE_PATH+"/profile");
    }

    public Response updateprofile(Object payload, String token){

        setauthtoken(token);
        return putRequest(payload,BASE_PATH+"/profile");
    }


}
