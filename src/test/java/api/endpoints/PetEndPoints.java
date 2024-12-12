package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	
	
	public static Response PetcreateUser (Pet payload) {
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.pet_post_url);
		
		return response;
		
	}
	

	public static Response petGetUser(String id) {
		
		Response response = given()
			.pathParam("petId", id)
		.when()
			.get(Routes.pet_get_url);
		return response;
		
	}
	
	
//	public static Response petUpdateUser(String id, Pet payload) {
//		Response response=given()
//			.pathParam("petId", id)
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.body(payload)
//		.when()
//			.put(Routes.pet_put_url);
//		
//		return response;
//	}
	
	public static Response petDeleteUser(String id) {
		
		Response response = given()
			.pathParam("petId", id)
		.when()
			.delete(Routes.pet_delete_url);
		
		return response;
		
	}

}
