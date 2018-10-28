package RestAssured.Basics;

import java.util.Properties;

import io.restassured.http.Method;
import org.codehaus.groovy.runtime.metaclass.MethodMetaProperty.GetBeanMethodMetaProperty;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.apiData;
import testData.getStatusCode;
import utility.JSONDataReader;

public class BasicGet extends JSONDataReader
{   
    public void getWeatherDetails(){
    	RestAssured.baseURI = newURL();
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("q",getCity());
		requestParams.put("appid",appID());
		httpRequest.body(requestParams.toJSONString());
//		Response response = httpRequest.get();
		Response response = httpRequest.request(Method.GET);
		System.out.print(httpRequest);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, getStatusCode.ok);
		System.out.println(statusCode);
//		System.out.println(response.getBody().asString());
    }
}
