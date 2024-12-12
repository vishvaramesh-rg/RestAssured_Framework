package api.endpoints;


/*
 * Swagger 	Post	- https://petstore.swagger.io/v2/user
 * 			Get		- https://petstore.swagger.io/v2/user/{username}	
 * 			put		- https://petstore.swagger.io/v2/user/{username}
 * 			delete	- https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	 //user EndPoints
		
	public static String base_Url = "https://petstore.swagger.io/v2";
	
	
	
	public static String post_Url = base_Url+"/user";
	public static String get_Url = base_Url+"/user/{username}";
	public static String put_Url = base_Url+"/user/{username}";
	public static String delete_Url = base_Url+"/user/{username}";
	
	
	
	
	//Store EndPoints
	
	/*
	 * post -https://petstore.swagger.io/v2/store/order
	 * Get - https://petstore.swagger.io/v2/store/order/{orderid}
	 * delete - https://petstore.swagger.io/v2/store/order/{orderid}
	 * 
	 */
	public static String base_store_Url = "https://petstore.swagger.io/v2/store";
	
	public static String store_post_url= base_store_Url+"/order";
	public static String store_get_url = base_store_Url+"/order/{orderid}";
	public static String store_delete_url= base_store_Url+"/order/{orderid}";
	
	//pet EndPoints
	
	//https://petstore.swagger.io/v2/pet
	//https://petstore.swagger.io/v2/pet/9223372036854775807
	public static String pet_post_url = base_Url+"/pet";
	public static String pet_get_url = base_Url+"/pet/{petId}";
	//public static String pet_put_url = base_Url+"/pet/{petId}";
	public static String pet_delete_url = base_Url+"/pet/{petId}";
	
	

}
