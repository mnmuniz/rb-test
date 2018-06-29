package delete.users;

import static com.jayway.restassured.RestAssured.expect;
import static main.matchers.numeric.IntegerMatcher.isInteger;
import static main.matchers.strings.StringMatcher.isString;
import static main.utils.ModuleUrls.urlUsers;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Test;

import main.MainApi;
import main.utils.CreateTests;
import main.utils.DateGetters;

public class DeleteUsers extends MainApi {

	Random rand = new Random();
	public String nameTimestamp = new DateGetters().getDate(0, "yyyy-MM-dd'T'HH:mm:ss:SS");
	
@Test	
		public void deleteUsers () {
	
		Integer id = rand.nextInt(999); 
		JSONObject userBody = new JSONObject ();
		userBody.put("id",id.toString() );
		userBody.put("firstName", "name@"+nameTimestamp);
		userBody.put("lastName", "Doe");
		userBody.put("age", rand.nextInt(90));
		userBody.put("companyId", "1");
	
		String idCreated = CreateTests.createUser(urlUsers, userBody);
	
		expect().statusCode(200)
		.when().delete(urlUsers+id);
	
}

		@Test	
		public void searchDeletedUser () {

		Integer id = rand.nextInt(999); 
			JSONObject userBody = new JSONObject ();
			userBody.put("id",id.toString() );
			userBody.put("firstName", "name@"+nameTimestamp);
			userBody.put("lastName", "Doe");
			userBody.put("age", rand.nextInt(90));
			userBody.put("companyId", "1");

			String idCreated = CreateTests.createUser(urlUsers, userBody);

			expect().statusCode(200)
			.when().delete(urlUsers+id);
			
			//returns 404 not found
			expect().statusCode(404)
			.given().headers(authHeader)
			.when().get(urlUsers+idCreated);
			

}


}
