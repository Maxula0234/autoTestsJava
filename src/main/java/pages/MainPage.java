package pages;

import annotations.UrlPrefix;
import components.SpecializationsComponent;
import components.header_menu.HeaderMenu1Component;
import components.header_menu.HeaderMenu2Component;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {

    public HeaderMenu1Component headerMenu1Component;
    public HeaderMenu2Component headerMenu2Component;
    public SpecializationsComponent specializationsComponent;

    @FindBy(css = ".cookies .cookies__button")
    private WebElement cookieButton;

    @FindBy(xpath = "//button[@data-modal-id='new-log-reg']")
    private WebElement buttonLogin;

    @FindBy(css = ".new-input-line_relative input[type=text][name=email]")
    private WebElement emailInput;

    @FindBy(css = ".new-input-line_relative input[name=password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[contains(@class,'new-input-line_relative')]/button")
    private WebElement buttonEnter;

    @FindBy(css = ".header2-menu__icon .header2-menu__icon-img")
    private WebElement icon;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu1Component = new HeaderMenu1Component(driver);
        headerMenu2Component = new HeaderMenu2Component(driver);
        specializationsComponent = new SpecializationsComponent(driver);
    }

    public MainPage inputLogin(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonEnter));
        emailInput.sendKeys(login);
        return this;
    }

    public MainPage inputPassword(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonEnter));
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage enterLogIn() {
        buttonEnter.click();
        return this;
    }

    public MainPage clickLoginOrReg() {
        buttonLogin.click();
        return this;
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

    public void checkLogin() {
        webDriverWait.until(ExpectedConditions.visibilityOf(icon)).isDisplayed();
    }
}
