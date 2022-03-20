package ui.courses;

import annotations.Driver;
import annotations.WaitDriver;
import components.header_menu.HeaderMenu1Component;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.services.SubscriptionPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(UIExtension.class)
public class HeadersTest {

    @WaitDriver
    public WebDriverWait webDriverWait;

    @Driver
    WebDriver driver;

    @Test
    @DisplayName("Проверим страницу с информацией о подписке")
    public void checkSubscription() {
        MainPage mainPage = new MainPage(driver).open();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mainPage.cookieButton)).click();
        HeaderMenu1Component headerMenu1Component = new HeaderMenu1Component(driver);
        SubscriptionPage subscriptionPage = headerMenu1Component.clickAndReturn(headerMenu1Component.subscription, SubscriptionPage.class);

        assertAll(
                () -> assertTrue(subscriptionPage.info.isDisplayed()),
                () -> assertThat(subscriptionPage.optionItemComponent).isNotEmpty()
        );

        log.info("Блок с информацией о подписках: Отображен");
        log.info("Блок с информацией о видах подписок: Отображен");
    }

    @Test
    @DisplayName("Проверим страницу с отзывами")
    public void checkReviews() {

    }
}
