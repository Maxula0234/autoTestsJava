package pages.categories;

import components.BaseCourseTileComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CategoryLessonsPage extends BasePage<CategoryLessonsPage> {

    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public CategoryLessonsPage(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, lessons);
    }

    public List<WebElement> getLessons() {
        return lessons;
    }

}
