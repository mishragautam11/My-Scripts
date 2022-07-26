package Begning;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

public class Reqres_Api {


    @Test
    public void testapi(){

        Response response=RestAssured.get("https://reqres.in/api/users?page=2");

        int status = response.getStatusCode();
        System.out.println(status);
        Assert.assertEquals(status,200);
        String Id = response.getSessionId();
        System.out.println(Id);

        String body = response.getBody().asString();
        System.out.println(body);


    }





}
