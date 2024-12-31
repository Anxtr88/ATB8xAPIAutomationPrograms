package com.APITestingPrograms.Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting013_Assertions {

    @Test
    public void test_hardAssertion(){
        System.out.println("Start of the program");
        Assert.assertTrue(false);
        System.out.println("End of the program");
    }

    @Test
    public void test_softAssertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed.");
    }


}
