package com.sagnik80.Requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sagnik80.Global.BaseData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestToken {
	
	public RequestToken() throws IOException  {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response getToken(String URL, String Key, int StatusCode) throws IOException{

		RestAssured.baseURI= URL;
		Response res =given().
		param("api_key", Key).log().all().
		when().
		get("3/authentication/token/new").
		then().
		assertThat().statusCode(StatusCode).and().
		contentType(ContentType.JSON).
		extract().response();
		
    	return res;
}
	
}
