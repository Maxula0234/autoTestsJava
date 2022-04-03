package pages.categories;

import annotations.UrlPrefix;
import components.BaseCourseTileComponent;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/categories/programming/")
@Slf4j
public class ProgrammingCategoriesPage extends BasePage<ProgrammingCategoriesPage> {

    public BaseCourseTileComponent baseCourseTileComponent;

    public ProgrammingCategoriesPage(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, getLessons());
    }

    public List<WebElement> getLessons() {
        return driver.findElements(By.xpath("//div[@class='lessons__new-item-container']"));
    }

    @Step("Получим урок {nameLesson}")
    public void getLessonByName(String nameLesson) {
        List<WebElement> lessons = getLessons();
        WebElement webElement = lessons.stream()
                .filter(f -> f.getText().contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Урок с именем " + nameLesson + " не найден"));

        assertThat(webElement).as("Урок не найден").isNotNull();
    }
}
