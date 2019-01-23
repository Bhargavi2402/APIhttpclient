package com.qa.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class NewTest extends TestBase {
	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	CloseableHttpResponse closehttpresponse;
	RestClient restclient;
	 @BeforeMethod
		public void setup() throws ClientProtocolException, IOException{
		testbase = new TestBase();
		 serviceurl = prop.getProperty("URL");
		 apiurl = prop.getProperty("serviceurl");
		url = serviceurl+apiurl;
		

}
	 
  @Test
  public void gettest() throws ClientProtocolException, IOException {
	   restclient = new RestClient();
	   closehttpresponse=restclient.get(url);
		//status code
		int statuscode = closehttpresponse.getStatusLine().getStatusCode();//return the response code
		System.out.println("status code :"+statuscode);
		assertEquals(statuscode, 200,"Status code is not 200");
		
		
	//jsong string
		String responsesuite = EntityUtils.toString(closehttpresponse.getEntity(), "UTF-8");
		JSONObject jsonobject = new JSONObject(responsesuite);
		System.out.println("response json of API "+jsonobject);
		
  }
}
