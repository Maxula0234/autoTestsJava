package pages.services;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

@UrlPrefix("/subscription")
public class SubscriptionPage extends BasePage<SubscriptionPage> {

    @FindBy(xpath = "//div[contains(@class,'doKqzP')]//h2[text()='Как работает подписка?']")
    public WebElement info;

    @FindBy(xpath = "//div[contains(@class,'kqgEaR')]")
    public List<WebElement> optionItemComponent;

    public SubscriptionPage(WebDriver webDriver) {
        super(webDriver);
    }

}
