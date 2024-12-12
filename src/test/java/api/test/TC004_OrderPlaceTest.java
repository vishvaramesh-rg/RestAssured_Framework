package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class TC004_OrderPlaceTest {
	
	Faker f;
	Store userpayload;
	Logger logger;
	String id;
	SoftAssert sa;
	
	@BeforeClass
	public void setup() {
		
		logger = LogManager.getLogger(this.getClass());
		
		f= new Faker();
		userpayload = new Store();
		sa = new SoftAssert();
		
		userpayload.setId(f.number().digits(6));
		userpayload.setPetId(f.idNumber().hashCode());
		userpayload.setQuantity(2);
		userpayload.setShipDate("2024-12-12T10:42:08.082Z");
		userpayload.setStatus("placed");
		userpayload.setComplete(false);	
		
	}
	
	@Test(priority = 1)
	public void testPostStore() {
		
		logger.info("***** placing order *****");
		
		Response response = StoreEndPoints.placeOrder(userpayload);

		sa.assertEquals(response.getStatusCode(), 200);
		
		id = response.jsonPath().get("id").toString();
		
		sa.assertEquals(response.jsonPath().getString("status"), "placed");
		sa.assertEquals(response.header("Content-Type"), "application/json");
		sa.assertAll();
		response.then().log().all();
		logger.info("***** order placed *****");
		
	}
	
	@Test(priority = 2)
	public void testGetPlacedOrder() {
		
		logger.info("***** get placed order *****");
		
		System.out.println(this.id);
		Response response = StoreEndPoints.getOrders(this.userpayload.getId());
		sa.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		sa.assertAll();
		logger.info("***** received placed order *****");
	
		
	}
	
	@Test(priority = 3)
	public void testDeleteOrder() {
		logger.info("***** Delete order *****");
		
		Response response = StoreEndPoints.deleteOrder(this.userpayload.getId());
		sa.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		sa.assertAll();
		
		logger.info("***** order deleted *****");
	}

}
