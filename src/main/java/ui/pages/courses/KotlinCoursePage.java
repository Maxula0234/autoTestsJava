package ui.pages.courses;

import ui.annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/kotlin")
public class KotlinCoursePage extends BasePage<KotlinCoursePage> {

    public KotlinCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkKotlinCoursePage(){
        assertThat(getTitlePage()).as("").isNotEmpty();
    }
}
