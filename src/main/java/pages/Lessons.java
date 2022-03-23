package pages;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPrefix("/lessons")
public class Lessons extends BasePage<Lessons> {

    @FindBy(xpath = "//div[@data-elem-type=\"button\"]/div[@class='tn-atom' and contains(text(),'Специализация')]")
    public WebElement spec;

    @FindBy(xpath = "//div[@field='tn_text_1613568838724']")
    public WebElement startDate;

    public Lessons(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
