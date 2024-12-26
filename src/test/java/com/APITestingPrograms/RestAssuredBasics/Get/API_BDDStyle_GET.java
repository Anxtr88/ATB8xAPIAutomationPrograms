package com.APITestingPrograms.RestAssuredBasics.Get;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_BDDStyle_GET {

    @Test
    public void test_Get_Req(){

        String pin_code = "400070";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_Get_Req_negative(){

        String pin_code = "-1";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }
}
