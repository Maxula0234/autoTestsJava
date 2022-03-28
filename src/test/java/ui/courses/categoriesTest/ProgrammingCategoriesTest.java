package ui.courses.categoriesTest;

import annotations.Driver;
import dao.CourseTileItem;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@Slf4j
@ExtendWith(UIExtension.class)
public class ProgrammingCategoriesTest {
    @Driver
    WebDriver driver;

    @ParameterizedTest
    @CsvSource({
            "Kotlin Backend Developer",
            "Highload Architect",
            "Android Developer. Basic",
            "Software Architect"
    })
    public void goToLesson(String name) {
        MainPage mainPage = new MainPage(driver)
                .open()
                .acceptCookie();

        CourseTileItem lessonByName = mainPage.headerMenu2Component
                .moveToCoursesHeaderMenu()
                .moveToProgrammingHeaderSubMenuItem()
                .goToProgrammingCategoriesPage()
                .baseCourseTileComponent.getLessonByName(name);

        lessonByName.goToLesson();
    }
}
