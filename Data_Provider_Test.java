package DataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Data_Provider_Test {


    @DataProvider(name = "Data_Provider")
    public Object[][] data(){

        Object[][] objects = new Object[2][2];

        objects[1][0]= "Home";
        objects[1][1]= "sweet";
        return objects;
    }

    @Test(dataProvider = "Data_Provider")
    public void post_test(String title, String author){

        baseURI="http://localhost:3000/";

        JSONObject response = new JSONObject();
        response.put("title", title);
        response.put("author",author);

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
