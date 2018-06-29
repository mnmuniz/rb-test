package main;

import static com.jayway.restassured.RestAssured.defaultParser;



import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.ErrorLoggingFilter;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.filter.session.SessionFilter;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;





public class MainApi {

	protected static SessionFilter sessionFilter;
	protected static ErrorLoggingFilter errorLoggingFilter;
	protected static ResponseLoggingFilter responseLoggingFilter;
	protected static RequestLoggingFilter requestLoggingFilter;	
	public static Headers loginHeaders;

	@BeforeClass
	public static void init() {
		sessionFilter = new SessionFilter();
		loginHeaders = 	new Headers(new Header("Accept", "application/json"),
						new Header("Content-Type", "application/json"));
		defaultParser = Parser.JSON;
		errorLoggingFilter = new ErrorLoggingFilter(System.out);
		
		String logging = System.getProperty("Logging.verbose"); 
		
		 
	
		
		if(logging == null || Boolean.valueOf(logging)){
			responseLoggingFilter = new ResponseLoggingFilter(LogDetail.ALL, System.out);
			requestLoggingFilter = new RequestLoggingFilter(LogDetail.ALL, System.out);
		} else {
			responseLoggingFilter = new ResponseLoggingFilter(LogDetail.STATUS, System.out);
			requestLoggingFilter = new RequestLoggingFilter(LogDetail.PATH, System.out);
		}
		RestAssured.filters(errorLoggingFilter, responseLoggingFilter, requestLoggingFilter);
		RestAssured.useRelaxedHTTPSValidation();
		

		
	}
	

	public static String baseURI = "http://localhost:80/";
	
	public  Headers authHeader = new Headers(new Header("Accept", "application/json"),
			new Header("Content-Type", "application/json; charset=utf-8")
			);

	


	
}