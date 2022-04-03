package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SpecializationBasePage;

import java.util.List;

@Component("//div[@class='container container-lessons']//div[@class='container-padding-bottom']")
public class SpecializationsComponent extends BaseComponent<SpecializationsComponent> {

    private final String ds = baseLocator + "//div[@class='lessons__new-item-container']";
    public BaseCourseTileComponent baseCourseTileComponent;

    public SpecializationsComponent(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, getLessons());
    }

    public List<WebElement> getLessons() {
        return driver.findElements(By.xpath(baseLocator + "//div[@class='lessons__new-item-container']"));
    }

    public SpecializationBasePage goToSpecializationByName(String nameCourse) {
        List<WebElement> lessons = getLessons();
        WebElement webElement = lessons.stream()
                .filter(f -> f.getText().contains(nameCourse))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдена специализация - " + nameCourse));
        webElement.click();
        return new SpecializationBasePage(driver);
    }

}
