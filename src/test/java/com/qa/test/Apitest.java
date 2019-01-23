package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Apitest extends TestBase{
	TestBase testbase;
	 @BeforeMethod
		public void setup() throws ClientProtocolException, IOException{
		testbase = new TestBase();
		String serviceurl = prop.getProperty("URL");
		String apiurl = prop.getProperty("serviceurl");
		String url = serviceurl+apiurl;
		RestClient restclient = new RestClient();
		restclient.get(url);

}
	 
}
