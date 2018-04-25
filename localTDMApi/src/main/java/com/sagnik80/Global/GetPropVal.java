package com.sagnik80.Global;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GetPropVal {
	Properties prop = new Properties();
	public GetPropVal() throws IOException{
		System.getProperty("user.dir");
		FileInputStream filepath = new FileInputStream("src/main/java/com/sagnik80/Global/Global.properties");
		prop.load(filepath);
	}
	public String getHost() throws IOException{
		String url = prop.getProperty("HOST");
		return url;		
	}
	public String getKey(){
		String key =prop.getProperty("KEY");
		if(key!= null) return key;
		else throw new RuntimeException("Report Config Path not specified in the Global.properties file for the Key:KEY");	
	}
	public String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Global.properties file for the Key:reportConfigPath");		
	}
}
