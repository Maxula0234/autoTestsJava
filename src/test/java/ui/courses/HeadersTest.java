package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import helpers.HelperString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.courses.KotlinCoursePage;
import pages.courses.PythonCoursePage;
import pages.services.ContactsPage;
import pages.services.FaqPage;
import pages.services.ReviewsPage;
import pages.services.SubscriptionPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(UIExtension.class)
public class HeadersTest {
    @Driver
    WebDriver driver;

    @Test
    @DisplayName("Откроем курс по питону")
    public void openCoursePython() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open()
                .moveElementAction(mainPage.headerMenu2Component.coursesHeaderMenu)
                .moveElementAction(mainPage.headerMenu2Component.testingHeaderSubMenuItem)
                .moveElementAction(mainPage.headerMenu2Component.testingSubMenuDpTriger);

        PythonCoursePage pythonCoursePage = mainPage.moveElementAndClickAction(mainPage.headerMenu2Component.pythonCoursesElement, PythonCoursePage.class);
        assertThat(pythonCoursePage.getTitlePage()).isEqualToIgnoringCase("Курс по автоматизации тестирования и поиска неисправностей в бекенде и фронтенде с использованием Selenium и языка Python");
    }

    @Test
    @DisplayName("Откроем курс 'Kotlin Backend Developer'")
    public void openCourseKotlin() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open()
                .moveElementAction(mainPage.headerMenu2Component.coursesHeaderMenu)
                .moveElementAction(mainPage.headerMenu2Component.programmingHeaderSubMenuItem)
                .moveElementAction(mainPage.headerMenu2Component.programmingSubMenuDpTriger);

        KotlinCoursePage pythonCoursePage = mainPage.moveElementAndClickAction(mainPage.headerMenu2Component.kotlinBackendCoursesElement, KotlinCoursePage.class);
    }

    @Test
    @DisplayName("Проверим страницу с информацией о подписке")
    public void checkSubscription() {
        SubscriptionPage subscriptionPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToSubscription();

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
        ReviewsPage reviewsPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToReviews();

        assertThat(reviewsPage.reviewsItems).isNotEmpty();
    }

    @Test
    @DisplayName("Переход с главной на FAQ")
    public void checkGoToFaq() {
        FaqPage faqPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToFaqPage();

        assertThat(faqPage.headerInfo.isDisplayed()).isTrue();
        assertThat(faqPage.faqBlockComponent.faqBlockButton).isNotEmpty();
    }

    @Test
    @DisplayName("Переход с главной в контакты")
    public void checkGoToContacts() {
        ContactsPage contactsPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToContactsPage();

        contactsPage.socialMediaComponent.checkSocialMedia();

        log.info("Страница контактов отображена");
        log.info("Социальные сети видны");
    }

    @Test
    @DisplayName("Проверка реквизитов")
    public void checkRequisites() {
        ContactsPage contactsPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToContactsPage();

        List<String> collect = Arrays.stream(contactsPage.requisites.getText().split("\n"))
                .collect(Collectors.toList());

        Map<String, String> stringStringMap = HelperString.parseStringToMap(collect);

        assertAll(
                () -> assertThat(stringStringMap.get("ООО")).contains("«Отус онлайн-образование»"),
                () -> assertThat(stringStringMap.get("ИНН")).contains("9705100963"),
                () -> assertThat(stringStringMap.get("КПП")).contains("771401001"),
                () -> assertThat(stringStringMap.get("ОГРН")).contains("1177746618576"),
                () -> assertThat(stringStringMap.get("ОКПО")).contains("16102045"),
                () -> assertThat(stringStringMap.get("ОКАТО")).contains("4528650000"),
                () -> assertThat(stringStringMap.get("АО")).contains("«АЛЬФА-БАНК»"),
                () -> assertThat(stringStringMap.get("Р/С")).contains("40702810601300013780"),
                () -> assertThat(stringStringMap.get("К/С")).contains("30101810200000000593"),
                () -> assertThat(stringStringMap.get("БИК")).contains("044525593")
        );
    }

}
