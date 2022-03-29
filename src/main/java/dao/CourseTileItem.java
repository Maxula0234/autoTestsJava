package dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

@Data
@NoArgsConstructor
public class CourseTileItem {
    WebDriver driver;
    private WebElement date;
    private WebElement name;
    private WebElement thisElement;

    public LessonsBasePage goToLesson() {
        thisElement.click();
        return new LessonsBasePage(driver);
    }

    public SpecializationBasePage goToSpecialization() {
        thisElement.click();
        return new SpecializationBasePage(driver);
    }
}
