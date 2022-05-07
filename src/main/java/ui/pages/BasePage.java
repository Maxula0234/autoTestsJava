package ui.pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.actions.CommonActions;
import ui.annotations.UrlPrefix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public abstract class BasePage<T> extends CommonActions<T> {

    public Logger reporter = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }

    private String getBaseUrl() {
        return StringUtils.stripEnd(System.getProperty("webdriver.base.url"), "/");
    }

    private String getUrlPrefix() {
        UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
        if (urlAnnotation != null) {
            return urlAnnotation.value();
        }

        return "";
    }

    @Step("Открываем страницу")
    public T open() {
        driver.get(getBaseUrl() + getUrlPrefix());

        return (T) page(getClass());
    }

    public <T> T page(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
            return convertInstanceOfObject(constructor.newInstance(driver), clazz);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public String getUrl() {
        return getBaseUrl() + getUrlPrefix();
    }

    public void waitAndClick(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
