package com.sagnik80.Requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sagnik80.Global.BaseData;
import com.sagnik80.Resources.PayLoad;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TvCertifications {

//	public TvCertifications() throws IOException  {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Response getTvCertifications(String URL, String Key, int StatusCode) throws IOException{
	//public static void main (String[] args) throws IOException{
		//int StatusCode= 200;
//		BaseData base = new BaseData();
//		System.out.println("In "+PayLoad.tvCertifications);
		RestAssured.baseURI= URL;
		Response res =given().
		param("api_key", Key).log().all().
		when().
		get(PayLoad.tvCertifications).
		then().
		assertThat().statusCode(StatusCode).and().
		contentType(ContentType.JSON).
		extract().response();
		
		String certificate = BaseData.getJsonField(res, "certifications.US[0].ceritification");

		System.out.println("Certificate : "+res);
    	return res;
}
	
}
