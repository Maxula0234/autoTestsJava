package ui.courses;

import ui.annotations.Driver;
import ui.components.FavouriteCoursesComponent;
import ui.extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;

@Slf4j
@ExtendWith(UIExtension.class)
public class FavouriteCourseTest {

    @Driver
    public WebDriver driver;

    @Test
    @DisplayName("Кликнем по первому популярному курсу")
    public void click_favourite_course_tile() {
        new MainPage(driver).open();
        new FavouriteCoursesComponent(driver)
                .baseCourseTileComponent
                .goToLesson(0);
    }


}
