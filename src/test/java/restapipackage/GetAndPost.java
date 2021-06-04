package restapipackage;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPost {
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		Map<String, Object> postMap = new HashMap<String, Object>();
//		postMap.put("name", "Barath");
//		postMap.put("job", "SDET");
//		
//		System.out.println(postMap);
		
		JSONObject request = new JSONObject(postMap);
		request.put("name", "Barath");
		request.put("job", "SDET");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when().post("/users").then().statusCode(201).log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_2_put() {
			Map<String, Object> postMap = new HashMap<String, Object>();
//			postMap.put("name", "Barath");
//			postMap.put("job", "SDET");
//			
//			System.out.println(postMap);
			
			JSONObject request = new JSONObject(postMap);
			request.put("name", "Barath");
			request.put("job", "SDET");
			System.out.println(request.toJSONString());
			baseURI = "https://reqres.in/api";
			given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_2_patch() {
		Map<String, Object> postMap = new HashMap<String, Object>();
//		postMap.put("name", "Barath");
//		postMap.put("job", "SDET");
//		
//		System.out.println(postMap);
		
		JSONObject request = new JSONObject(postMap);
		request.put("name", "Barath");
		request.put("job", "SDET");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
     }
	
	@Test
	public void test_2_delete() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then().statusCode(204).log().all();
	}
}
