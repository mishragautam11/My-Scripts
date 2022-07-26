package Begning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Test01 {

@Test
    public void rest_assure(){

    Response response=RestAssured.get("https://gorest.co.in/public/v2/users");

    int statuscode = response.getStatusCode();

    Assert.assertEquals(statuscode,200);
    System.out.println("Status code =" +statuscode);

    String body = response.getBody().asString();
    System.out.println("Response body"+body);

    String header = String.valueOf(response.getHeaders());
    System.out.println("Response Header" + header);




}
}
