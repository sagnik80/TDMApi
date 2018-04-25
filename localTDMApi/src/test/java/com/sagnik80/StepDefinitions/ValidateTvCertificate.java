package com.sagnik80.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.sagnik80.Global.BaseData;
import com.sagnik80.Requests.RequestToken;
import com.sagnik80.Requests.TvCertifications;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class ValidateTvCertificate  {
	protected int tc;
	protected Response res;
	private static Logger  log = LogManager.getLogger(ValidateTvCertificate.class.getName());
//	@Before
//	public static void getData() throws IOException{
//		BaseData b = new BaseData();
//	}
	@Given("^\"([^\"]*)\" User logs in to TMDB$")
	public void login(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("authorized")){
			tc=0;
			log.info("Positive Flow TV", "Authorized User");
		} else {
			tc =1;
			log.info("Negative Flow TV", "UnAuthorized User");
		}
	}

	@When("^User request to get the TV Certificate and Status as \"([^\"]*)\"$")
	public void requestTVCertificate(int Status) throws Throwable {
		TvCertifications sId = new TvCertifications();
		
		if (tc==0){
			System.out.println("Test Case "+tc);
			res= sId.getTvCertifications(BaseData.getURL(),BaseData.getKey(),Status);
		}else {
			System.out.println("Test Case "+tc);
			String Key =BaseData.getKey()+1;
			res = sId.getTvCertifications(BaseData.getURL(), Key,Status);
		}
		System.out.println(res );
		log.info("Response Received", res.asString(), "Status Code", Status);
	}


	@Then("^TV Certificate Details is returned in accordance$")
	public void ValidatetvCertificate() throws Throwable {
		System.out.println("Done");
		//More Code similar to Token Request to be added to validate specific fields in the response
	}


}
