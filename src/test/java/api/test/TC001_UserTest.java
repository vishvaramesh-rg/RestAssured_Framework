package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class TC001_UserTest {
	Faker f;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		
		 f = new Faker();
		 userPayload = new User(); //	POJO CLASS	
		 
		 userPayload.setId(f.idNumber().hashCode());
		 userPayload.setUsername(f.name().fullName());
		 userPayload.setFirstName(f.name().firstName());
		 userPayload.setLastName(f.name().lastName());
		 userPayload.setEmail(f.internet().emailAddress());
		 userPayload.setPassword(f.internet().password(5, 10));
		 userPayload.setPhone(f.phoneNumber().cellPhone());	
		 
		 //logger
		 logger = LogManager.getLogger(this.getClass());
		 
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("***** Create user*******");
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		response.then().log().all();
		logger.info("*****User Created*******");
	
	}
	
	@Test(priority = 2)
	public void testGetUser() {
			
		logger.info("***** Get user*******");
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("*****Received user body*******");
		
	}
	
	@Test(priority = 3)
	public void testPutUser() {
		
		//updating the existing data
		userPayload.setEmail(f.internet().emailAddress());
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		
		//getting the response after updation
		logger.info("*****Updating user body*******");
		Response AfterUpdatedResponse = UserEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		Assert.assertEquals(AfterUpdatedResponse.getStatusCode(), 200);
		AfterUpdatedResponse.then().log().all();
		logger.info("*****User body is updated*******");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		logger.info("*****Deleting user*******");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("*****User deleted*******");
	}
	
	

}
