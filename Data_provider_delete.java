package DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class Data_provider_delete {



    @Parameters({"Id"})

    @Test
    public void delete_api(int Id) {
        baseURI = "http://localhost:3000/";

        given().delete("/posts/"+Id).
                then().statusCode(200);
    }
}