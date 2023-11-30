package web_automation.tests.utils;

public class Verifier {
    public static void assertEquals(String actual, String expected){
        // handle exception
        if(!actual.equals(expected)){
            throw new RuntimeException("[AssertionError] Expecting " + actual + " to be equal " + expected);
        }
    }
}
