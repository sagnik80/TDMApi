package com.sagnik80.StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import com.cucumber.listener.Reporter;
import com.sagnik80.Global.BaseData;
import com.sagnik80.Requests.RequestToken;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class ValidateToken  {
 
	protected int tc ;
	protected int Status;
	protected Response res;
	private static Logger  log = LogManager.getLogger(ValidateToken.class.getName());
	@Before
	public static void getData() throws IOException{

		BaseData b = new BaseData();
	}
	@Given("^User is  \"([^\"]*)\" to access TMDB$")
	public void login(String userType) throws Throwable {
		if(userType.equalsIgnoreCase("authorized")){
			tc=0;
			log.info("Positive Flow - Token", "Authorized User");
		} else {
			tc =1;
			log.info("Negative Flow - Token", "UnAuthorized User");
		}
	}

	@When("^User request to get the Token and Status as \"([^\"]*)\"$")
	public void request_Token(int Status) throws Throwable {
		RequestToken sId = new RequestToken();
		System.out.println(BaseData.getURL());
		System.out.println(BaseData.getKey());
		if (tc==0){
			res= sId.getToken(BaseData.getURL(), BaseData.getKey(), Status);		
		}else {
			String Key =BaseData.getKey()+1;
			res = sId.getToken(BaseData.getURL(), Key, Status);
		}
		//System.out.println(res );
		//Reporter.addStepLog(res.asString());
		log.info("Response Received Token");
		log.info(res.asString());
	}

	@Then("^Request Token is returned in accordance$")
	public void validate_session() throws Throwable {
		String returnKey;
		if (tc==0){
			returnKey =BaseData.getJsonField(res, "request_token");
			System.out.println(returnKey );
			Assert.assertTrue(returnKey!=null);
			if (returnKey!=null){
				log.info("Authorized User "+returnKey);
			}
		}else if (tc==1) {
			returnKey =BaseData.getJsonField(res, "status_message");
			Assert.assertTrue(returnKey!=null);
			if (returnKey!=null){
				log.info("For Invalid User "+returnKey);
			}
		}
	}

}
