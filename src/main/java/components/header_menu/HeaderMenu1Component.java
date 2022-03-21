package components.header_menu;

import annotations.Component;
import components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.services.ReviewsPage;
import pages.services.SubscriptionPage;

@Component("//header[@class='header2_subheader']")
public class HeaderMenu1Component extends BaseComponent<HeaderMenu1Component> {

    @FindBy(xpath = ".//a[@title='Подписка']")
    public WebElement subscription;

    @FindBy(xpath = ".//a[@title='Отзывы']")
    public WebElement reviews;

    @FindBy(xpath = ".//a[@title='FAQ']")
    public WebElement faq;

    @FindBy(xpath = ".//a[@title='OTUS JOURNAL']")
    public WebElement otusJournal;

    @FindBy(xpath = ".//a[@title='Контакты']")
    public WebElement contacts;

    public HeaderMenu1Component(WebDriver webDriver) {
        super(webDriver);
    }

    public SubscriptionPage goToSubscription() {
        subscription.click();
        return new SubscriptionPage(driver);
    }

    public ReviewsPage goToReviews() {
        reviews.click();
        return new ReviewsPage(driver);
    }
}
