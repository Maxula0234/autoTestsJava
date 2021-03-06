package ui.components.headermenu;

import ui.annotations.Component;
import ui.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.services.ContactsPage;
import ui.pages.services.FaqPage;
import ui.pages.services.ReviewsPage;
import ui.pages.services.SubscriptionPage;

@Component("//header[@class='header2_subheader']")
public class HeaderMenu1Component extends BaseComponent<HeaderMenu1Component> {

    @FindBy(xpath = ".//a[@title='Подписка']")
    private WebElement subscription;

    @FindBy(xpath = ".//a[@title='Отзывы']")
    private WebElement reviews;

    @FindBy(xpath = ".//a[@title='FAQ']")
    private WebElement faq;

    @FindBy(xpath = ".//a[@title='OTUS JOURNAL']")
    private WebElement otusJournal;

    @FindBy(xpath = ".//a[@title='Контакты']")
    private WebElement contacts;

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

    public FaqPage goToFaqPage() {
        faq.click();
        return new FaqPage(driver);
    }

    public ContactsPage goToContactsPage() {
        contacts.click();
        return new ContactsPage(driver);
    }
}
