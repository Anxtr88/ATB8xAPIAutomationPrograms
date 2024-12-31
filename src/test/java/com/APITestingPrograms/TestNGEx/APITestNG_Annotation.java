package com.APITestingPrograms.TestNGEx;

import org.testng.annotations.*;

public class APITestNG_Annotation {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Token Test Before test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Token Test Before Method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Token Test Before Class");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("test2");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Token Test After test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Token Test After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Token Test After Class");
    }


}
