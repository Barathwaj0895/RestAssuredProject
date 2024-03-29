package restapipackage;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {
	
	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		given().param("name", "Automation")
		.get("/subjects").then().statusCode(200).log().all();
	}
	
	@SuppressWarnings("unchecked")
	//@Test
	public void test_post() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Nikola");
		request.put("lastname", "Tesla");
		request.put("subjectId", 1);
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000/";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json").body(request.toJSONString())
		.when().post("/users")
		.then().statusCode(201).log().all();
	}
	
	@SuppressWarnings("unchecked")
	//@Test
	public void test_patch() {
		JSONObject request = new JSONObject();
//		request.put("firstname", "Manjula");
		request.put("lastname", "Pannerselvam");
//		request.put("subjectId", 1);
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000/";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json").body(request.toJSONString())
		.when().patch("/users/4")
		.then().statusCode(200).log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_put() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Ravisankar");
		request.put("lastname", "Rangachari");
		request.put("subjectId", 1);
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000/";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json").body(request.toJSONString())
		.when().put("/users/6")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	public void test_delete() {
		baseURI = "http://localhost:3000/";
		when().delete("/users/7")
		.then().statusCode(200);
	}
}
