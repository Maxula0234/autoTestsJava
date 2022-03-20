package pages;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;

@UrlPrefix("/lessons")
public class Lessons extends BasePage<Lessons> {

    public Lessons(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
