package main.utils;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.json.simple.JSONObject;

import main.MainApi;



public class CreateTests {
	

		public static String createUser(String url, JSONObject body) {
			Collection<String> fieldCollection = body.keySet();
			ArrayList<String> fieldArrayList = new ArrayList<String>();
			fieldArrayList.addAll(fieldCollection);
			
			HashMap<Object, Object> bodyResult = expect().statusCode(201)
			.given().headers(new MainApi().authHeader)
			.body(body)
			.when().post(url).then().extract().path("");
			
			Integer removedAmount = fieldsToRemove(fieldArrayList);
			String field,value;
			for(int i=0;i<body.size()-removedAmount;i++){
				field = fieldArrayList.get(i);
				value = body.get(field).toString();
				bodyResult.get(field).equals(value);
			}
			
			return bodyResult.get("id").toString();
		}
		

		public static Integer fieldsToRemove(ArrayList<String> fieldsList){
			Integer count=0;
			String[] fields = {"file"};
			for(int i=0;i<fields.length;i++){
				fieldsList.remove(fields[i]);
				count++;
			}
			return count;
		}
}
