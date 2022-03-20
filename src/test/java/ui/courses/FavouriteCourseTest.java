package ui.courses;

import annotations.Driver;
import annotations.WaitDriver;
import components.FavouriteCoursesComponent;
import components.SpecializationsComponent;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Lessons;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(UIExtension.class)
public class FavouriteCourseTest {

    @Driver
    public WebDriver driver;

    @WaitDriver
    public WebDriverWait webDriverWait;

    @Test
    public void click_favourite_course_tile() {
        new MainPage(driver).open();

        new FavouriteCoursesComponent(driver)
                .clickLessonItem()
                .getPageTitle();
    }

    @ParameterizedTest
    @CsvSource({"Специализация С++",
            "Специализация QA Automation Engineer"})
    public void specializationTest(String nameCourse) {
        MainPage mainPage = new MainPage(driver).open();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mainPage.cookieButton))
                .click();

        Lessons lessons = new SpecializationsComponent(driver)
                .clickLesson(nameCourse);
        String pageTitle = lessons.getPageTitle();

        assertThat(pageTitle).isEqualToIgnoringCase(nameCourse);
        log.info("Успешно перешли на страницу курса - " + pageTitle);
    }
}
