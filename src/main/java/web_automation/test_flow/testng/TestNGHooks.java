package web_automation.test_flow.testng;

import org.testng.annotations.*;

public class TestNGHooks {
    /*
    * BeforeSuit
    * BeforeTest
    * BeforeClass
    * BeforeMethod
    * */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before suite!");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test!");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method!");
    }
    @Test
    public void test1(){
        System.out.println("\nTest method 1");
    }
    @Test
    public void test2(){
        System.out.println("\n Test method 2");
    }
}
