package lab_12.tests;

import lab_12.models.components.ComponentExploring;
import lab_12.models.components.ExternalLoginPage;
import lab_12.models.components.InternalLoginPage;

public class GenericTypeTest {
    public static void main(String[] args) {
        ComponentExploring componentExploring = new ComponentExploring();
        componentExploring.login(InternalLoginPage.class, "Internal user");
        componentExploring.login(ExternalLoginPage.class, "External user");
    }
}
