package Filters;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingFilter implements Filter {

    //private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class.getName());

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
     logRequest(requestSpec);
     Response response= ctx.next(requestSpec, responseSpec);
     logResponse(response);
        return response;
    }


    public void logRequest(FilterableRequestSpecification requestSpec) {

        logger.info("BASE URI: " + requestSpec.getBaseUri() );
        logger.info("HEADER: " + requestSpec.getHeaders() );
        logger.info("REQUEST PAYLOAD: " + requestSpec.getBody() );
    }

    public void logResponse(Response response) {
        logger.info("BASE URI: " + response.getStatusCode() );
        logger.info("HEADER: " + response.getBody().prettyPrint() );
        logger.info("REQUEST PAYLOAD: " + response.headers() );



    }
}
