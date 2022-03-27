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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Component("//div[contains(@class,'dHdjyV') and text()='Социальные сети']")
public class SocialMediaComponent extends BaseComponent<SocialMediaComponent> {

    @FindBy(xpath = "//a[text()='Вконтакте']")
    public WebElement vk;

    @FindBy(xpath = "//a[text()='Facebook']")
    public WebElement faceBook;

    @FindBy(xpath = "//a[text()='ОК']")
    public WebElement ok;

    @FindBy(xpath = "//a[text()='Дзен']")
    public WebElement dzen;

    @FindBy(xpath = "//a[text()='YouTube']")
    public WebElement youTube;

    @FindBy(xpath = "//a[text()='Канал в Telegram']")
    public WebElement channelTelegram;

    @FindBy(xpath = "//a[text()='Группа в Telegram']")
    public WebElement groupTelegram;

    public SocialMediaComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Проверим отображение социальных сетей")
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
        log.info("Социальные сети отображены");
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
