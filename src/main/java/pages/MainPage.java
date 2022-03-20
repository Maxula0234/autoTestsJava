package pages;

import annotations.UrlPrefix;
import components.header_menu.HeaderMenu2Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {

    public HeaderMenu2Component headerMenu2Component;

    @FindBy(css = ".header2__auth-container")
    public WebElement reg;

    @FindBy(xpath = "//div[@class='cookies__margin-block js-cookie']//button[text()='Œ ']")
    public WebElement cookieButton;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu2Component = new HeaderMenu2Component(driver);
    }

    public MainPage moveElementAction(WebElement webElement) {
        actions.moveToElement(webElement).pause(300).perform();
        return this;
    }

}
