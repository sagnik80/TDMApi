package com.sagnik80.Global;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

	public class BaseData {
		protected static String URL;
		protected static String Key;
		protected static GetPropVal host ;
		protected static String extentReport;
//Constructor created to get the required data from the Global Properties
		public BaseData() throws IOException {
			host = new GetPropVal();
			BaseData.URL =host.getHost();
			BaseData.Key= host.getKey();
			BaseData.extentReport =host.getReportConfigPath();
		}
//getters for URL	
		public static String getURL() {
			return URL;
		}
//getters for Key		
		public static String getKey() {
			Key= host.getKey();
			return Key;
		}

//to parse the Json response to get a particular field from the reponse		
		public static String getJsonField(Response res, String s){
			//Get the id/required field from the response
			String responseAdd =res.asString();
			System.out.println(responseAdd);
			JsonPath js = new JsonPath(responseAdd);
			String placeIdAdd =js.get(s);
			System.out.println("placeIdAdd: "+placeIdAdd);
			return placeIdAdd;
		}

	}

