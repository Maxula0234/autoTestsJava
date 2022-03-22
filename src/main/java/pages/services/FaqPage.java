package pages.services;

import annotations.UrlPrefix;
import components.faqPage.FaqBlockComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

@UrlPrefix("/faq")
public class FaqPage extends BasePage<FaqPage> {
    @FindBy(xpath = "//h1[normalize-space( text())='Отвечаем на ваши']")
    public WebElement headerInfo;

    @FindBy(xpath = "//div[contains(@class,'faq-question__question')]")
    public List<WebElement> questions;

    public FaqBlockComponent faqBlockComponent;

    public FaqPage(WebDriver driver) {
        super(driver);
        faqBlockComponent = new FaqBlockComponent(driver);
    }
}