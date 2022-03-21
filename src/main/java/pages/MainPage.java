package pages;

import annotations.UrlPrefix;
import components.SpecializationsComponent;
import components.header_menu.HeaderMenu1Component;
import components.header_menu.HeaderMenu2Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {

    public HeaderMenu1Component headerMenu1Component;
    public HeaderMenu2Component headerMenu2Component;
    public SpecializationsComponent specializationsComponent;

    @FindBy(css = ".header2__auth-container")
    public WebElement reg;

    @FindBy(xpath = "//div[@class='cookies__margin-block js-cookie']//button[text()='Œ ']")
    public WebElement cookieButton;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu1Component = new HeaderMenu1Component(driver);
        headerMenu2Component = new HeaderMenu2Component(driver);
        specializationsComponent = new SpecializationsComponent(driver);
    }

    public MainPage moveElementAction(WebElement webElement) {
        actions.moveToElement(webElement).pause(300).perform();
        return this;
    }

    public MainPage acceptCookie() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        return this;
    }

}
