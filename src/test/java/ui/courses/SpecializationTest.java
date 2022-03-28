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
import pages.MainPage;
import pages.SpecializationBasePage;

@Slf4j
@ExtendWith(UIExtension.class)
public class SpecializationTest {

    @Driver()
    WebDriver driver;

    @ParameterizedTest
    @DisplayName("Выбор и переход по специализации")
    @CsvSource({"Специализация С++",
            "Специализация QA Automation Engineer"})
    public void specializationTest(String nameCourse) {
        new MainPage(driver)
                .open()
                .acceptCookie()
                .specializationsComponent.baseCourseTileComponent
                .getLessonByName(nameCourse)
                .goToSpecialization()
                .checkPage();

    }

    @Test
    @DisplayName("Выбор и переход по специализации с ближайшей датой")
    public void specializationTestChoiceFirstByDate() {
        SpecializationBasePage specializationBasePage = new MainPage(driver)
                .open()
                .acceptCookie()
                .specializationsComponent.baseCourseTileComponent
                .sortedLessonByDate()
                .clickSpecialization(0);

        specializationBasePage.checkPage();
    }
}
