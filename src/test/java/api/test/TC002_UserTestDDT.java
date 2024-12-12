package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class TC002_UserTestDDT {
	
	
	@Test(priority = 1, dataProvider = "data",dataProviderClass = Dataproviders.class)
	public void CreateUserbyDDT(String userid, String name, String fname, String lname, String email, String pwd, String phn) {
		
		User userpayload = new User();
		userpayload.setId(Integer.parseInt(userid));
		userpayload.setUsername(name);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(pwd);
		userpayload.setPhone(phn);
		
		Response response = UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);	
		
	}
	
	@Test(priority = 2,dataProvider = "username", dataProviderClass = Dataproviders.class)
	public void deleteUserByUsername(String uname) {
		
		Response response = UserEndPoints.deleteUser(uname);
		Assert.assertEquals(response.getStatusCode(), 200);	
		
	}

}
