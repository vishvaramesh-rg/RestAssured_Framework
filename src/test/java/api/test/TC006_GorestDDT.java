package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.GorestUserEndpionts;
import api.payload.Gorest;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class TC006_GorestDDT {
	
	
	Logger log;
	public final String bearer ="539fb519312c5cd5cf33c341fc3f2f3e7444bffde4ae4559dab9c1f1fc317eb2";
	public int userid;
	
	@Test(priority = 1 ,dataProvider = "data",dataProviderClass = Dataproviders.class)
	public void testCreateUser(String name, String email, String gender, String status ) {
		
		Gorest gorestpayload=new Gorest();
		log = LogManager.getLogger(this.getClass());
		
		
		log.info("***** Create user *******");
		
		gorestpayload.setName(name);
		gorestpayload.setEmail(email);
		gorestpayload.setGender(gender);
		gorestpayload.setStatus(status);
		
		Response response = GorestUserEndpionts.CreateUser(gorestpayload, bearer);
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		userid = response.jsonPath().getInt("id");
		
		System.out.println(userid);
		
		log.info("*****User Created*******");
		
		log.info("Response: " + response.asString());
		
		log.info("***** Delete user *******");
		
		Response deleteresponse = GorestUserEndpionts.deleteUser(bearer, userid);
		Assert.assertEquals(deleteresponse.getStatusCode(), 204);
		
		log.info("***** user deleted *******");

	    }


}
