package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import waiters.StandartWaiter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class CommonActions<T> {

    protected WebDriver driver;
    protected StandartWaiter standartWaiter;
    protected Actions actions;
    protected WebDriverWait webDriverWait;


    protected BiConsumer<By, Predicate<? super WebElement>> clickElementByPredicate = (By locator, Predicate<? super WebElement> predicate) -> {
        List<WebElement> elements = driver.findElements(locator).stream()
                .filter(predicate)
                .collect(Collectors.toList());

        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    };

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.webDriverWait = new WebDriverWait(driver, 45);

        PageFactory.initElements(driver, this);
        standartWaiter = new StandartWaiter(driver);
    }

    private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }

    public <T extends BasePage> T clickAndReturn(WebElement webElement, Class<T> page) {
        webElement.click();
        try {
            Constructor<T> constructor = page.getConstructor(WebDriver.class);
            return convertInstanceOfObject(constructor.newInstance(driver), page);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends BasePage> T moveElementAndClickAction(WebElement webElement, Class<T> page) {
        actions.moveToElement(webElement).click().build().perform();
        try {
            Constructor<T> constructor = page.getConstructor(WebDriver.class);
            return convertInstanceOfObject(constructor.newInstance(driver), page);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

}
