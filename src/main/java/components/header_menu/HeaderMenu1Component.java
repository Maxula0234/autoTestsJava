package components.header_menu;

import annotations.Component;
import components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Component("//header[@class='header2_subheader']")
public class HeaderMenu1Component extends BaseComponent<HeaderMenu1Component> {

    @FindBy(xpath = ".//a[@title='��������']")
    public WebElement subscription;

    @FindBy(xpath = ".//a[@title='������']")
    public WebElement reviews;

    @FindBy(xpath = ".//a[@title='FAQ']")
    public WebElement faq;

    @FindBy(xpath = ".//a[@title='OTUS JOURNAL']")
    public WebElement otusJournal;

    @FindBy(xpath = ".//a[@title='��������']")
    public WebElement contacts;

    public HeaderMenu1Component(WebDriver webDriver) {
        super(webDriver);
    }

}
