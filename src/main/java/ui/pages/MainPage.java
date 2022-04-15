package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.annotations.UrlPrefix;
import ui.components.SpecializationsComponent;
import ui.components.headermenu.HeaderMenu1Component;
import ui.components.headermenu.HeaderMenu2Component;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {

    public HeaderMenu1Component headerMenu1Component;
    public HeaderMenu2Component headerMenu2Component;
    public SpecializationsComponent specializationsComponent;

    @FindBy(css = ".header2__auth-container")
    private WebElement reg;

    @FindBy(css = ".cookies .cookies__button")
    private WebElement cookieButton;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu1Component = new HeaderMenu1Component(driver);
        headerMenu2Component = new HeaderMenu2Component(driver);
        specializationsComponent = new SpecializationsComponent(driver);
    }

    public void clickReg() {
        reg.click();
    }

    public MainPage moveElementAction(WebElement webElement) {
        actions.moveToElement(webElement).pause(300).perform();
        return this;
    }

    public MainPage acceptCookie() {

        try {
            cookieButton.click();
        } catch (WebDriverException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", cookieButton);

        }

        return this;
    }
}
