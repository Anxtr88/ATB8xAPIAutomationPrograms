package com.APITestingPrograms.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateToken_NonBDDStyle {


    @Description("Verify Create Token")
    @Test
    public void Create_Token() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification reqspec = RestAssured.given();
        reqspec.baseUri("https://restful-booker.herokuapp.com");
        reqspec.basePath("/auth");
        reqspec.contentType(ContentType.JSON).log().all();
        reqspec.body(payload);
        Response response = reqspec.when().post();
        response.then().log().all().statusCode(200);


    }
}
