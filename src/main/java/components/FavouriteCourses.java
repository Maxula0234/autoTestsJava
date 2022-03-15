package components;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@Component("//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div[@class='lessons']")
public class FavouriteCourses extends BaseComponent<FavouriteCourses> {

    @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div/a")
    private List<WebElement> lessons;

    public FavouriteCourses(WebDriver driver) {
        super(driver);
    }

    public Lessons clickLessonItem() {
        if (lessons.isEmpty()){
            fail("Популярные курсы не найдены");
        }
        lessons.get(0).click();

        return new Lessons(driver);
    }

}
