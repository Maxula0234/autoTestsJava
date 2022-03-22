package pages.services;

import components.contacts.SocialMediaComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ContactsPage extends BasePage<ContactsPage> {
    @FindBy(xpath = "//div[contains(@class,'kfHYcg')]/div[text()='Контакты']")
    public WebElement title;

    public SocialMediaComponent socialMediaComponent;

    public ContactsPage(WebDriver driver) {
        super(driver);
        socialMediaComponent = new SocialMediaComponent(driver);
    }
}
