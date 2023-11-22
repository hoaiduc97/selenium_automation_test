package lab_12.models.components;

public class FindComponent {
    public <T> String getComponentCssSelector(Class<T> componentClass){
        return componentClass.getAnnotation(ComponentCSSSelector.class).value();
    }
}
