package create.users;

import static com.jayway.restassured.RestAssured.expect;
import static main.matchers.numeric.IntegerMatcher.isInteger;
import static main.matchers.strings.StringMatcher.isString;
import static org.hamcrest.Matchers.equalTo;
import static main.utils.ModuleUrls.urlUsers;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Test;

import main.utils.CreateTests;
import main.utils.DateGetters;
import main.BaseApiTest;

public class CreateUsers extends BaseApiTest {
	
	Random rand = new Random();
	public String nameTimestamp = new DateGetters().getDate(0, "yyyy-MM-dd'T'HH:mm:ss:SS");
	
	@Test
	public void createUserEntireMethod() {
		
		Integer id = rand.nextInt(999); 
		JSONObject userBody = new JSONObject ();
		userBody.put("id",id.toString() );
		userBody.put("firstName", "name@"+nameTimestamp);
		userBody.put("lastName", "Doe");
		userBody.put("age", rand.nextInt(90));
		userBody.put("companyId", "1");
		
		expect().statusCode(201)
		.body("firstName", equalTo(userBody.get("firstName")))
		.given().headers(authHeader)
		.body(userBody)
		.when().post(urlUsers);
		
	}
	
	
	@Test
	public void createUsingFunctions() {
		
		Integer id = rand.nextInt(999); 
		JSONObject userBody = new JSONObject ();
		userBody.put("id",id.toString() );
		userBody.put("firstName", "name@"+nameTimestamp);
		userBody.put("lastName", "Doe");
		userBody.put("age", rand.nextInt(90));
		userBody.put("companyId", "1");
		
		String idCreated = CreateTests.createUser(urlUsers, userBody);
		
		expect().statusCode(200)
		.body(	"id", isString(),
				"firstName", isString(),
				"lastName", isString(),
				"age", isInteger(),
				"companyId", isString()
				)
		.given().headers(authHeader)
		.when().get(urlUsers+idCreated);
		
	}

	@Test
	public void failCreateAnUserWithSameId() {
		
		 
		JSONObject userBody = new JSONObject ();
		userBody.put("id","1");
		userBody.put("firstName", "name@"+nameTimestamp);
		userBody.put("lastName", "Doe");
		userBody.put("age", rand.nextInt(90));
		userBody.put("companyId", "1");
		
		//RestApi Returns 500 Error Insert failed, duplicate id (should have error handling)
		expect().statusCode(500)
		.given().headers(authHeader)
		.body(userBody)
		.when().post(urlUsers);
		
	}
	

}
