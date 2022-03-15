package pages;

import annotations.UrlPrefix;
import components.header_menu.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.courses.PythonCoursePage;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {
    public HeaderMenuComponent headerMenuComponent;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenuComponent = new HeaderMenuComponent(driver);
    }

    public MainPage moveElementAction(WebElement webElement) {
        actions.moveToElement(webElement).pause(300).perform();
        return this;
    }

}
