package pages.courses;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@UrlPrefix("/lessons/avtomatizaciya-web-testirovaniya/")
public class PythonCoursePage extends BasePage<PythonCoursePage> {

    public PythonCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

}
