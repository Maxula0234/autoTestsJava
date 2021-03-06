package ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.annotations.Component;

import java.util.List;

@Component("//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div[@class='lessons']")
public class FavouriteCoursesComponent extends BaseComponent<FavouriteCoursesComponent> {

    public BaseCourseTileComponent baseCourseTileComponent;
    private final By dateLessonStart = By.xpath(".//div[@class='lessons__new-item-time']");

    @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div/a")
    private List<WebElement> lessons;

    public FavouriteCoursesComponent(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, getLessons());
    }

    public List<WebElement> getLessons() {
        return driver.findElements(By.xpath(baseLocator + "//div[@class='lessons__new-item-container']"));
    }

}
