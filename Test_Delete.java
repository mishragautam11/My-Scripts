package Http_Response;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Test_Delete {

    @Test
    public void delete_api(){
        baseURI="http://localhost:3000/";

        given().delete("/posts/2").
                then().statusCode(200);





    }
}
