package ui.courses;

import annotations.Driver;
import annotations.WaitDriver;
import components.FavouriteCoursesComponent;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

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

}
