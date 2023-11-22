package lab_12.tests;

import lab_12.models.components.FindComponent;
import lab_12.models.components.FooterComponent;

public class AnnotationTest {
    public static void main(String[] args) {
       String footerComponentSel = new FindComponent().getComponentCssSelector(FooterComponent.class);
        System.out.println(footerComponentSel);
    }
}
