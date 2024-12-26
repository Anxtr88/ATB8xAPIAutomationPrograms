package com.APITestingPrograms.RestAssuredBasics.Get;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_NonBDDStyleGET {

    static RequestSpecification r = RestAssured.given();

    @Description("TC1 Verify pincode with positive data")
    @Test
    public void test_NonBDDStyle() {
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/400070");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Description("TC2 Verify pincode with negative data")
    @Test
    public void test_NonBDDStyle_negative() {
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);

    }


}
