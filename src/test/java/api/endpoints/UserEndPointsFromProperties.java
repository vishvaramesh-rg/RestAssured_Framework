package api.endpoints;

import java.util.ResourceBundle;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserEndPointsFromProperties {


	static ResourceBundle getUrl(){
		ResourceBundle route = ResourceBundle.getBundle("route");
		return route;
	}


	public static Response create_user(User payload) {
		String post_url = getUrl().getString("post_url");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept("application/json")
			.body(payload)
		
		.when()
			.post(post_url);

		return response;
	}
	
	public static Response getUser(String userName) {
		
		String get_url =getUrl().getString("get_url");
		
		Response response=given()
				.pathParam("username", userName)
			.when()
				.get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(User payload, String userName) {
		String put_url = getUrl().getString("put_url");
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept("application/json")
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(put_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName) {
		
		String delete_url = getUrl().getString("delete_url");
		
		Response response = given()
			.pathParam("username", userName)
		.when()
			.delete(delete_url);
		
		return response;
	}
	
}
