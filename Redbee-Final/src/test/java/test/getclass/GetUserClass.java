package test.getclass;

import static com.jayway.restassured.RestAssured.expect;
import static main.matchers.numeric.IntegerArrayMatcher.isIntegerArray;
import static main.matchers.numeric.IntegerMatcher.isInteger;
import static main.matchers.strings.StringArrayMatcher.isStringArray;
import static main.matchers.strings.StringMatcher.isString;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.everyItem;


import org.junit.Test;

import main.BaseApiTest;


 
public class GetUserClass extends BaseApiTest {
	
	
	
	@Test
	public void shouldReturnCompleteList(){
		expect().statusCode(200)
		.body(	"output.id", isIntegerArray(),
				"output.firstName", isStringArray(),
				"output.lastName", isStringArray(),
				"output.email", isStringArray(),
				"output.age", isStringArray(),
				"output.companyId", isIntegerArray()
				)
		.given().headers(authHeader)
		.when().get(baseURI+"users");
	}
	
	@Test
	public void shouldGetFirstUser() {
		String url = "users";
		String id = "1";
		
		expect().statusCode(200)
		.body(	"id", isString(),
				"firstName", isString(),
				"lastName", isString(),
				"email", isString(),
				"age", isInteger(),
				"companyId", isString()
				)
		.given().headers(authHeader)
		.when().get(baseURI+url+"/"+id);
		}
	
}
