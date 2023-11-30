package web_automation.tests.verifier;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web_automation.tests.BaseTest;

public class VerifierTest extends BaseTest {
    @Test
    public void testHandleAssertion(){
        // Hard Assertion
        Assert.assertEquals("Teo", "Ti", "Display name is different");
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }
    // Test Soft Assertion
    @Test
    public void testSoftAssertion() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2);
        softAssert.assertTrue(true);
        softAssert.assertFalse(true);
        softAssert.fail("I want to");
        softAssert.assertAll();
    }
}
