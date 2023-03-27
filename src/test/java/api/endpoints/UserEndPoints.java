package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import api.payload.User;
import io.restassured.http.ContentType;

//CRUD methods implementation
//UserEndpoints java file 
//Created to perform Create, Read, Update, Delete requests to the User services 


public class UserEndPoints
{
	
	//Creating User
	public static Response createUser(User payload)   //will be calling from user POJO class
	{
		Response response =
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);  //since it is static we can access directly but if it is private we need 
		                                     //to create object of the class and then call it here with the method
		return response;
	}
	
	
	//Read User
	public static Response readUser(String userName) // will only require only parameter 
	{
		Response response = 
				given()
					.pathParam("username", userName)
				.when()
					.get(Routes.get_url);
		return response;
	}

	
	//Update User
	public static Response updateUser(String userName, User payload) //which user i want to update(1st param), and payload
	{
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(payload)
				.when()
					.put(Routes.update_url);
		return response;
	}
	
	//Delete User

	public static Response deleteUser(String userName)
	{
		Response response = 
				given()
					.pathParam("username", userName)
				.when()
					.delete(Routes.delete_url);
		return response;
	}
}