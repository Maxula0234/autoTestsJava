package ui.courses;

import ui.annotations.Driver;
import ui.extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;
import ui.pages.courses.PythonCoursePage;
import ui.pages.services.ContactsPage;
import ui.pages.services.FaqPage;
import ui.pages.services.ReviewsPage;
import ui.pages.services.SubscriptionPage;

@Slf4j
@ExtendWith(UIExtension.class)
public class HeadersTest {
    @Driver
    WebDriver driver;

    @Test
    @DisplayName("Откроем курс по питону")
    public void openCoursePython() {
        MainPage mainPage = new MainPage(driver)
                .open()
                .acceptCookie();

        mainPage.headerMenu2Component
                .moveToCoursesHeaderMenu()
                .moveToTestingHeaderSubMenuItem()
                .moveToTestingSubMenuDpTrigger();

        PythonCoursePage pythonCoursePage = mainPage.headerMenu2Component.goToPythonCourse();
        pythonCoursePage.checkOpenPage();
    }

    @Test
    @DisplayName("Проверим страницу с информацией о подписке")
    public void checkSubscription() {
        SubscriptionPage subscriptionPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToSubscription();

        subscriptionPage.checkSubscriptionPage();

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

        reviewsPage.checkReviewsPage();
    }

    @Test
    @DisplayName("Переход с главной на FAQ")
    public void checkGoToFaq() {
        FaqPage faqPage = new MainPage(driver)
                .open()
                .acceptCookie()
                .headerMenu1Component.goToFaqPage();
        faqPage.checkFaqPage();
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

        contactsPage.checkRequisites(contactsPage);
    }

}
