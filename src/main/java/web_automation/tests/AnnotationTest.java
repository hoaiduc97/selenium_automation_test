package web_automation.tests;

import web_automation.models.components.FindComponent;
import web_automation.models.components.global.footer.FooterComponent;

public class AnnotationTest {
    public static void main(String[] args) {
       String footerComponentSel = new FindComponent().getComponentCssSelector(FooterComponent.class);
        System.out.println(footerComponentSel);
    }
}
