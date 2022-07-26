package Http_Response;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test_Put {
    @Test
    public void put_api(){

        baseURI="http://localhost:3000/";

        JSONObject response = new JSONObject();
        response.put("title", "Jyoti");
        response.put("author","doctor");

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(response.toJSONString()).

                when().put("/posts/2").

                then().statusCode(200).log().all();


    }


}
