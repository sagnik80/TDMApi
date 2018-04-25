package com.sagnik80.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.listener.Reporter;
import com.sagnik80.Global.BaseData;
import com.sagnik80.Requests.MovieCertifications;
import com.sagnik80.Requests.RequestToken;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class ValidateMovieCertificate  {
	protected int tc;
	protected int Status;
	protected Response res;
	private static Logger  log = LogManager.getLogger(ValidateMovieCertificate.class.getName());
	
	@Given("^\"([^\"]*)\" user is logging in TMDB$")
	public void Login(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("authorized")){
			tc=0;
			log.info("Positive Flow Movie", "Authorized User");
		} else {
			tc =1;
			log.info("Negative Flow Movie", "UnAuthorized User");
		}
	}

	@When("^User request to get the Movie Certificate and Status as \"([^\"]*)\"$")
	public void requestMovie(int Status) throws Throwable {
		MovieCertifications sId = new MovieCertifications();
		System.out.println(BaseData.getURL());
		System.out.println(BaseData.getKey());
		if (tc==0){
			System.out.println(tc + "Status " +Status);
			res= sId.getMovieCertifications(BaseData.getURL(), BaseData.getKey(), Status);		
		}else {
			String Key =BaseData.getKey()+1;
			res = sId.getMovieCertifications(BaseData.getURL(), Key, Status);	
		}
		//System.out.println(res );
		log.info("Response Received", res.asString(), "Status Code", Status);
	}
	

	@Then("^Movie Certificate Details is returned successfully$")
	public void movie_Certificate_Details_is_returned_successfully() throws Throwable {
		System.out.println("Done");
		log.info("Then", "movie_Certificate_Details_is_returned_successfully");
		//More Code similar to Token Request to be added to validate specific fields in the response
	}

}
