package base;

import Filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseService {

  //Handling base uri and for creating request and for handing the response

    //Step 1 Declare a BASE URL

    static {
        RestAssured.filters(new LoggingFilter());
    }

    private static final String BASE_URL = "http://64.227.160.186:8080";

    private RequestSpecification requestSpecification;

    //Create Constructor
    public BaseService(){

       requestSpecification = given().baseUri(BASE_URL);

    }

    protected void setauthtoken(String token){
        requestSpecification.header("Authorization", "Bearer "+token);
    }
// header +payload +endpoint
    protected Response postRequest(Object payload, String endpoint){

        return requestSpecification
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);

    }


}
