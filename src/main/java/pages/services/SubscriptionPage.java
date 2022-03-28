package pages.services;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UrlPrefix("/subscription")
public class SubscriptionPage extends BasePage<SubscriptionPage> {

    @FindBy(xpath = "//div[contains(@class,'doKqzP')]//h2[text()='��� �������� ��������?']")
    private WebElement info;

    @FindBy(xpath = "//div[contains(@class,'kqgEaR')]")
    private List<WebElement> optionItemComponent;

    public SubscriptionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkSubscriptionPage() {
        assertAll(
                () -> assertThat(info.isDisplayed()).as("�� ��������� ������� '��� �������� ��������?'").isTrue(),
                () -> assertThat(optionItemComponent).as("�� ������� �������� ���������").isNotEmpty()
        );
    }
}
