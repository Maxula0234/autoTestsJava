package ui.components.contacts;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.annotations.Component;
import ui.components.BaseComponent;
import ui.pages.services.socialmedia.OkPublicPage;
import ui.pages.services.socialmedia.VkPublicPage;

import java.util.Set;

@Slf4j
@Component("//div[contains(@class,'dHdjyV') and text()='Социальные сети']")
public class SocialMediaComponent extends BaseComponent<SocialMediaComponent> {

    @FindBy(xpath = "//a[text()='Вконтакте']")
    private WebElement vk;

    @FindBy(xpath = "//a[text()='Facebook']")
    private WebElement faceBook;

    @FindBy(xpath = "//a[text()='ОК']")
    private WebElement ok;

    @FindBy(xpath = "//a[text()='Дзен']")
    private WebElement dzen;

    @FindBy(xpath = "//a[text()='YouTube']")
    private WebElement youTube;

    @FindBy(xpath = "//a[text()='Канал в Telegram']")
    private WebElement channelTelegram;

    @FindBy(xpath = "//a[text()='Группа в Telegram']")
    private WebElement groupTelegram;

    public SocialMediaComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Проверим отображение социальных сетей")
    public void checkSocialMedia() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(vk.isDisplayed()).as("Вк не отображен").isTrue(),
                () -> Assertions.assertThat(faceBook.isDisplayed()).as("FaceBook не отображен").isTrue(),
                () -> Assertions.assertThat(ok.isDisplayed()).as("ОК не отображен").isTrue(),
                () -> Assertions.assertThat(dzen.isDisplayed()).as("Дзен не отображен").isTrue(),
                () -> Assertions.assertThat(youTube.isDisplayed()).as("YouTube не отображен").isTrue(),
                () -> Assertions.assertThat(channelTelegram.isDisplayed()).as("Канал в ТГ не отображен").isTrue(),
                () -> Assertions.assertThat(groupTelegram.isDisplayed()).as("Группа в ТГ не отображена").isTrue()
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
