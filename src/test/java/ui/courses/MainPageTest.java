package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import pages.Lessons;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(UIExtension.class)
public class MainPageTest {

    @Driver()
    WebDriver driver;

    @Test
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .reg.click();
        String titlePage = mainPage.getTitlePage();
        assertThat(titlePage).isNotEmpty();
    }

    @ParameterizedTest
    @DisplayName("Выбор и переход по специализации")
    @CsvSource({"Специализация С++",
            "Специализация QA Automation Engineer"})
    public void specializationTest(String nameCourse) {
        Lessons lessons = new MainPage(driver)
                .open()
                .acceptCookie()
                .specializationsComponent.clickLesson(nameCourse);

        String pageTitle = lessons.getPageTitle();

        assertThat(pageTitle).isEqualToIgnoringCase(nameCourse);
        log.info("Успешно перешли на страницу курса - " + pageTitle);
    }

    @Test
    @DisplayName("Выбор и переход по специализации с ближайшей датой")
    public void specializationTestChoiceFirstByDate() {
        Lessons lessons = new MainPage(driver)
                .open()
                .acceptCookie()
                .specializationsComponent
                .sortedLessonByDate()
                .clickLessons(0);
        lessons.specIsDisplayed();
        log.info("Нашли курс с ближайшей датой - " + lessons.getStartDate().getText());
    }
}
