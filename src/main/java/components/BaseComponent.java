package components;

import actions.CommonActions;
import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseComponent<T> extends CommonActions<T> {

    protected String baseLocator;

    {
        this.standartWaiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(getComponentLocator()));
    }

    public BaseComponent(WebDriver driver) {
        super(driver);
    }

    public By getComponentLocator() {
        Component component = getClass().getAnnotation(Component.class);

        if (component != null) {
            String value = component.value();

            baseLocator = value;

            if (value.startsWith("/")) {
                return By.xpath(value);
            }
            return By.cssSelector(value);
        }

        return null;
    }

}
