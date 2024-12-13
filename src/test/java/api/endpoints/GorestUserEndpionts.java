package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.Gorest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GorestUserEndpionts {
	
	public static Response CreateUser(Gorest payload, String bearerToken) {
		
		Response response =  given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(payload)
		.when()
			.post(Routes.gorest_post_url);//Authorization
		
		return response;
		
	}
	
	public static Response getUser(String bearerToken, int userId) {
		
		Response response = given()
			.header("Authorization","Bearer "+bearerToken)
			.pathParam("userid", userId)
		.when()
			.get(Routes.gorest_get_url);
		
		return response;
		
	}
	
	public static Response UpdateUser(String bearerToken, Gorest payload, int userId) {
		
			Response response=given()
			.header("Authorization","Bearer "+bearerToken)
			.pathParam("userid",userId)
			.body(payload)
			.when()
				.put(Routes.gorest_get_url);
			
			return response;
	}
	
	public static Response deleteUser(String bearerToken, int id) {
		
		Response response = given()
				.header("Authorization","Bearer "+bearerToken)
				.pathParam("userid", id)
			.when()
				.delete(Routes.gorest_delete_url);
			
			return response;
		
	}

}
