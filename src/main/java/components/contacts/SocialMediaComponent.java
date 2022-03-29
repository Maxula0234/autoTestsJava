package components.contacts;

import annotations.Component;
import components.BaseComponent;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.services.social_media.OkPublicPage;
import pages.services.social_media.VkPublicPage;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Component("//div[contains(@class,'dHdjyV') and text()='���������� ����']")
public class SocialMediaComponent extends BaseComponent<SocialMediaComponent> {

    @FindBy(xpath = "//a[text()='���������']")
    private WebElement vk;

    @FindBy(xpath = "//a[text()='Facebook']")
    private WebElement faceBook;

    @FindBy(xpath = "//a[text()='��']")
    private WebElement ok;

    @FindBy(xpath = "//a[text()='����']")
    private WebElement dzen;

    @FindBy(xpath = "//a[text()='YouTube']")
    private WebElement youTube;

    @FindBy(xpath = "//a[text()='����� � Telegram']")
    private WebElement channelTelegram;

    @FindBy(xpath = "//a[text()='������ � Telegram']")
    private WebElement groupTelegram;

    public SocialMediaComponent(WebDriver driver) {
        super(driver);
    }

    @Step("�������� ����������� ���������� �����")
    public void checkSocialMedia() {
        assertAll(
                () -> assertThat(vk.isDisplayed()).as("�� �� ���������").isTrue(),
                () -> assertThat(faceBook.isDisplayed()).as("FaceBook �� ���������").isTrue(),
                () -> assertThat(ok.isDisplayed()).as("�� �� ���������").isTrue(),
                () -> assertThat(dzen.isDisplayed()).as("���� �� ���������").isTrue(),
                () -> assertThat(youTube.isDisplayed()).as("YouTube �� ���������").isTrue(),
                () -> assertThat(channelTelegram.isDisplayed()).as("����� � �� �� ���������").isTrue(),
                () -> assertThat(groupTelegram.isDisplayed()).as("������ � �� �� ����������").isTrue()
        );
        log.info("���������� ���� ����������");
    }

    public VkPublicPage goToVk() {
        goToWindow(vk);
        return new VkPublicPage(driver);
    }

    public OkPublicPage goToOk() {
        goToWindow(ok);
        return new OkPublicPage(driver);
    }

    private void goToWindow(WebElement webElement) {
        Set<String> windowHandles = driver.getWindowHandles();
        webElement.click();
        Set<String> windowHandlesAfter = driver.getWindowHandles();
        windowHandlesAfter.removeAll(windowHandles);

        driver.switchTo().window(windowHandlesAfter.iterator().next());
    }
}
