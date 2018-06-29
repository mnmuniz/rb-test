package put.users;

import static com.jayway.restassured.RestAssured.expect;
import static main.utils.ModuleUrls.urlUsers;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Test;

import main.MainApi;
import main.utils.CreateTests;
import main.utils.DateGetters;

public class PutUser extends MainApi {

	
	Random rand = new Random();
	public String nameTimestamp = new DateGetters().getDate(0, "yyyy-MM-dd'T'HH:mm:ss:SS");
	
	@Test
	public void createUserAndPutAllData() {
	
	Integer id = rand.nextInt(999); 
	JSONObject userBody = new JSONObject ();
	userBody.put("id",id.toString() );
	userBody.put("firstName", "name@"+nameTimestamp);
	userBody.put("lastName", "Doe");
	userBody.put("age", rand.nextInt(90));
	userBody.put("companyId", "1");
	
	String idCreated = CreateTests.createUser(urlUsers, userBody);
	
 
	JSONObject userBodyPut = new JSONObject ();
	//userBody.put("id",id.toString() );
	userBodyPut.put("firstName", "name@"+nameTimestamp);
	userBodyPut.put("lastName", "Doe");
	userBodyPut.put("age", rand.nextInt(90));
	userBodyPut.put("companyId", "1");
	
	expect().statusCode(200)
	.body("firstName", equalTo(userBodyPut.get("firstName")))
	.given().headers(authHeader)
	.body(userBodyPut)
	.when().put(urlUsers+idCreated);
	
	}
	
	
	
	@Test
	public void idDontChangeWithPut() {
	
	Integer id = rand.nextInt(999); 
	JSONObject userBody = new JSONObject ();
	userBody.put("id",id.toString() );
	userBody.put("firstName", "name@"+nameTimestamp);
	userBody.put("lastName", "Doe");
	userBody.put("age", rand.nextInt(90));
	userBody.put("companyId", "1");
	
	String idCreated = CreateTests.createUser(urlUsers, userBody);
	
 
	JSONObject userBodyPut = new JSONObject ();
	userBodyPut.put("id","32");
	userBodyPut.put("firstName", "name@"+nameTimestamp);
	userBodyPut.put("lastName", "Doe");
	userBodyPut.put("age", rand.nextInt(90));
	userBodyPut.put("companyId", "1");
	
	expect().statusCode(200)
	.body("firstName", equalTo(userBodyPut.get("firstName")),
			"id", equalTo(userBody.get("id")))
	.given().headers(authHeader)
	.body(userBodyPut)
	.when().put(urlUsers+idCreated);
	
	}
}
