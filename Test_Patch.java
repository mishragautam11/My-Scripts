package Http_Response;
import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Patch {
    @Test
    public void patch_api(){

        baseURI="http://localhost:3000/";

        JSONObject jb = new JSONObject();
        jb.put("title", "priya");

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jb.toJSONString()).

                when().patch("/posts/2").

                then().statusCode(200).log().all();


    }


}
