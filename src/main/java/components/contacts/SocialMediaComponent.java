package components.contacts;

import annotations.Component;
import components.BaseComponent;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Component("//div[contains(@class,'dHdjyV') and text()='���������� ����']")
public class SocialMediaComponent extends BaseComponent<SocialMediaComponent> {

    @FindBy(xpath = "//a[text()='���������']")
    public WebElement vk;

    @FindBy(xpath = "//a[text()='Facebook']")
    public WebElement faceBook;

    @FindBy(xpath = "//a[text()='��']")
    public WebElement ok;

    @FindBy(xpath = "//a[text()='����']")
    public WebElement dzen;

    @FindBy(xpath = "//a[text()='YouTube']")
    public WebElement youTube;

    @FindBy(xpath = "//a[text()='����� � Telegram']")
    public WebElement channelTelegram;

    @FindBy(xpath = "//a[text()='������ � Telegram']")
    public WebElement groupTelegram;

    public SocialMediaComponent(WebDriver driver) {
        super(driver);
    }

    @Step("�������� ����������� ���������� �����")
    public void checkSocialMedia() {
        assertAll(
                () -> assertTrue(vk.isDisplayed()),
                () -> assertTrue(faceBook.isDisplayed()),
                () -> assertTrue(ok.isDisplayed()),
                () -> assertTrue(dzen.isDisplayed()),
                () -> assertTrue(youTube.isDisplayed()),
                () -> assertTrue(channelTelegram.isDisplayed()),
                () -> assertTrue(groupTelegram.isDisplayed())
        );
        log.info("���������� ���� ����������");
    }
}
