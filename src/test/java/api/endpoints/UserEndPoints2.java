package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//User endpoints.java file
//Created for CURD requests for users api's


public class UserEndPoints2 {
	         
	
		//Method created for getting URL's from Properties file
			public static ResourceBundle getURL()
			{				
				ResourceBundle routes =ResourceBundle.getBundle("routes");//Loads the Properties file
				return routes;
				
			}

			public static Response createUser(User payload)
			{
				
				String  post_URL =getURL().getString("post_url");
				Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);
					
				return response;
			}
			
			
			public static Response readUser(String userName)
			{
				String  get_URL =getURL().getString("get_url");
				
				Response response=given()
								.pathParam("username",userName)
				.when()
					.get(Routes.get_url);
					
				return response;
			}
			
			
			public static Response updateUser(String userName, User payload)
			{
				
				String  update_URL =getURL().getString("update_url");
				Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(payload)
				.when()
					.put(Routes.update_url);
					
				return response;
			}
			
			
			public static Response deleteUser(String userName)
			{
				String  delete_URL =getURL().getString("delete_url");
				
				Response response=given()
								.pathParam("username",userName)
				.when()
					.delete(Routes.delete_url);
					
				return response;
			}	
			
	
}
