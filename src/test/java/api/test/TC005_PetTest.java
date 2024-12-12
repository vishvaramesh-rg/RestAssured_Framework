package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class TC005_PetTest {
	Faker f;
	Pet petPayload;
	Logger log;
	String id;
	SoftAssert sa;
	
	@BeforeClass
	public void setup() {
		
		f= new Faker();
		
		petPayload = new Pet();
		
		sa = new SoftAssert();
		
		log = LogManager.getLogger(this.getClass());
		
		petPayload.setName(f.name().firstName());
	}
	
	@Test(priority = 1)
	public void testCreatePet() {
		
		log.info("***** create new pet *****");
		
		Response response = PetEndPoints.PetcreateUser(petPayload);
		sa.assertEquals(response.getStatusCode(),200);
		
		sa.assertEquals(response.header("Content-Type"), "application/json");
		id = response.jsonPath().get("id").toString();
		
		System.out.println(id);
		response.then().log().all();
		
		log.info("***** new pet created *****");
	}
	
	
	@Test(priority = 2)
	public void testGePet() {
		log.info("***** Get created pet *****");
		
		Response response = PetEndPoints.petGetUser(id);
		sa.assertEquals(response.statusCode(),200);
		response.then().log().all();
		System.out.println(id);
		sa.assertAll();
		log.info("***** Received created pet *****");
		
	}
	
	
//	@Test(priority = 3)
//	public void testUpdatePet() {
//		
//		log.info("***** Update created pet *****");
//		
//		petPayload.setName(f.name().firstName());
//		
//		Response response = PetEndPoints.petUpdateUser(id, petPayload);
//		
//		Assert.assertEquals(response.getStatusCode(), 200);
//		response.then().log().all();
//		
//		log.info("***** Updated create pet *****");
//		
//	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		log.info("***** Delete pet *****");
		
		Response response = PetEndPoints.petDeleteUser(id);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		log.info("*****pet Delete *****");
	}
	
	
	
	

}
