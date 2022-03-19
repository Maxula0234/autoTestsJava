package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.courses.KotlinCoursePage;
import pages.courses.PythonCoursePage;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("Откроем курс по питону")
    public void openCoursePython() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open()
                .moveElementAction(mainPage.headerMenuComponent.coursesHeaderMenu)
                .moveElementAction(mainPage.headerMenuComponent.testingHeaderSubMenuItem)
                .moveElementAction(mainPage.headerMenuComponent.testingSubMenuDpTriger);

        PythonCoursePage pythonCoursePage = mainPage.moveElementAndClickAction(mainPage.headerMenuComponent.pythonCoursesElement, PythonCoursePage.class);
        assertThat(pythonCoursePage.getTitlePage()).isEqualToIgnoringCase("Курс по автоматизации тестирования и поиска неисправностей в бекенде и фронтенде с использованием Selenium и языка Python");
    }

    @Test
    @DisplayName("Откроем курс 'Kotlin Backend Developer'")
    public void openCourseKotlin() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open()
                .moveElementAction(mainPage.headerMenuComponent.coursesHeaderMenu)
                .moveElementAction(mainPage.headerMenuComponent.programmingHeaderSubMenuItem)
                .moveElementAction(mainPage.headerMenuComponent.programmingSubMenuDpTriger);

        KotlinCoursePage pythonCoursePage = mainPage.moveElementAndClickAction(mainPage.headerMenuComponent.kotlinBackendCoursesElement, KotlinCoursePage.class);
    }
}
