package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPointsFromProperties;
import api.payload.User;
import io.restassured.response.Response;

public class TC003_UserTestFromProperties {
	
	Faker f;
	User userpayload;
	Logger logger;
	
	@BeforeClass
	public void name() {
		
		f = new Faker();
		userpayload = new User();
		
		 userpayload.setId(f.idNumber().hashCode());
		 userpayload.setUsername(f.name().fullName());
		 userpayload.setFirstName(f.name().firstName());
		 userpayload.setLastName(f.name().lastName());
		 userpayload.setEmail(f.internet().emailAddress());
		 userpayload.setPassword(f.internet().password(5, 10));
		 userpayload.setPhone(f.phoneNumber().cellPhone());	
		 
		 //logger
		 logger =LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void testcreateUser() {
		logger.info("***** Create user*******");
		Response response = UserEndPointsFromProperties.create_user(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		response.then().log().body();
		logger.info("*****User Created*******");
	}
	
	@Test(priority = 2)
	public void testgetuser() {
		
		logger.info("***** Get user*******");
		Response response = UserEndPointsFromProperties.getUser(this.userpayload.getUsername());
		logger.info("*****Received user body*******");
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****Received user body*******");
		
	}
	
	@Test(priority = 3)
	public void testUpdateuser() {
		
		userpayload.setFirstName(f.name().firstName());
		userpayload.setPhone(f.phoneNumber().cellPhone());
		
		
		logger.info("*****Updating user body*******");
		Response UpdatedResponse = UserEndPointsFromProperties.updateUser(userpayload, this.userpayload.getUsername());
		UpdatedResponse.then().log().all();
		Assert.assertEquals(UpdatedResponse.getStatusCode(), 200);
		logger.info("*****User body is updated*******");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		logger.info("*****Deleting user*******");
		Response response = UserEndPointsFromProperties.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****User deleted*******");
		
	}

}
