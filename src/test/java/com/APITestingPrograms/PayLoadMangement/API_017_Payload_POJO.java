package com.APITestingPrograms.PayLoadMangement;

import com.APITestingPrograms.PayLoadMangement.POJO.Booking;
import com.APITestingPrograms.PayLoadMangement.POJO.BookingDates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class API_017_Payload_POJO {

    @Test
    public void testPOSTReq(){
        RequestSpecification requestSpecification;
        Response response;

//        {
//                    "firstname" : "Jim",
//                        "lastname" : "Brown",
//                        "totalprice" : 111,
//                        "depositpaid" : true,
//                        "bookingdates" : {
//                    "checkin" : "2018-01-01",
//                            "checkout" : "2019-01-01"
//                },
//                    "additionalneeds" : "Breakfast"
//                }

        // JSON -> Hashmap

        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingDates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " +  bookingId);





    }
}
