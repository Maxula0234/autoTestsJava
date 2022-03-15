package pages.courses;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@UrlPrefix("/kotlin")
public class KotlinCoursePage extends BasePage<KotlinCoursePage> {

    public KotlinCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

}
