package Http_Response;

import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class Test_Post {

    @Test
    public void testcase(){

        baseURI="http://localhost:3000/";

        JSONObject response = new JSONObject();
        response.put("title", "gautam");
        response.put("author","tester");

        //given().get("/posts").then().statusCode(200).log().all();
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(response.toJSONString()).
                when().
                post("/posts").
                then().
                statusCode(201).log().all();


    }
}
