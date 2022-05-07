package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.annotations.UrlPrefix;
import ui.components.SpecializationsComponent;
import ui.components.headermenu.HeaderMenu1Component;
import ui.components.headermenu.HeaderMenu2Component;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/")
public class MainPage extends BasePage<MainPage> {

    public HeaderMenu1Component headerMenu1Component;
    public HeaderMenu2Component headerMenu2Component;
    public SpecializationsComponent specializationsComponent;

    @FindBy(css = ".header2__auth-container")
    private WebElement reg;

    @FindBy(css = ".cookies .cookies__button")
    private WebElement cookieButton;

    @FindBy(css = "form[method=post] > .new-input-line > input[type=text]")
    private WebElement inputLogin;

    @FindBy(css = "form[method=post] > .new-input-line > input[type=password]")
    private WebElement password;

    @FindBy(xpath = "//form[@method='post']//button[contains(text(),'Войти')]")
    private WebElement submitButtonLogin;

    @FindBy(css = ".header2-menu__item-text__username")
    private WebElement nameAuthUser;

    public MainPage(WebDriver driver) {
        super(driver);
        headerMenu1Component = new HeaderMenu1Component(driver);
        headerMenu2Component = new HeaderMenu2Component(driver);
        specializationsComponent = new SpecializationsComponent(driver);
    }

    public MainPage clickReg() {
        waitAndClick(reg);
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

    public MainPage enterName(String login) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputLogin)).sendKeys(login);
        return this;
    }

    public MainPage enterPassword(String pass) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pass);
        return this;
    }

    public MainPage clickButtonEnter() {
        submitButtonLogin.click();
        return new MainPage(driver);
    }

    public void checkAuthClient() {
        assertThat(headerMenu2Component.getIconLogoClient().isDisplayed()).as("Клиент не авторизован").isTrue();
    }

    public void checkAuthClient(String expectedName) {
        String nameAuthUserText = nameAuthUser.getText();
        assertThat(nameAuthUserText).isEqualTo(expectedName);
    }
}
