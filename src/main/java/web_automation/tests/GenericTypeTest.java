package web_automation.tests;

import web_automation.models.components.ComponentExploring;
import web_automation.models.components.ExternalLoginPage;
import web_automation.models.components.InternalLoginPage;

public class GenericTypeTest {
    public static void main(String[] args) {
        ComponentExploring componentExploring = new ComponentExploring();
        componentExploring.login(InternalLoginPage.class, "Internal user");
        componentExploring.login(ExternalLoginPage.class, "External user");
    }
}
