package com.APITestingPrograms.PayLoadMangement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class API_016_Payload_Map {

    @Test
    public void testPOSTReq(){
        RequestSpecification requestSpecification;
        Response response;

        //{
        //            "firstname" : "Jim",
        //                "lastname" : "Brown",
        //                "totalprice" : 111,
        //                "depositpaid" : true,
        //                "bookingdates" : {
        //            "checkin" : "2018-01-01",
        //                    "checkout" : "2019-01-01"
        //        },
        //            "additionalneeds" : "Breakfast"
        //        }

        // JSON -> Hashmap


        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid", true);


        Map<String, Object> bookingDateMap = new LinkedHashMap();
        bookingDateMap.put("checkin","2018-01-01");
        bookingDateMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDateMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " +  bookingId);





    }
}
