package components;

import annotations.Component;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.util.List;

import static org.assertj.core.api.Assertions.fail;

@Component("//div[@class='container container-lessons']//div[@class='container-padding-bottom']")
public class SpecializationsComponent extends BaseComponent<SpecializationsComponent> {

    @FindBy(xpath = "//div[@class='lessons']//a[@class='lessons__new-item lessons__new-item_big lessons__new-item_hovered']//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public SpecializationsComponent(WebDriver webDriver) {
        super(webDriver);
    }

    public Lessons clickLesson(List<WebElement> listLessons, String nameLesson) {
        if (listLessons.isEmpty()) {
            fail("Специализации не найдены");
        }

        listLessons.stream()
                .filter(f -> f.getAttribute("text").contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Не найден курс - " + nameLesson))
                .click();
        return new Lessons(driver);
    }

    @Step("Нажимаем по курсу {nameLesson}")
    public Lessons clickLesson(String nameLesson) {
        if (lessons.isEmpty()) {
            fail("Специализации не найдены");
        }

        WebElement webElement = lessons.stream()
                .filter(f -> f.getText().contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Не найден курс - " + nameLesson));
        boolean result;

        webElement.click();
        return new Lessons(driver);
    }

    public List<WebElement> getLessons() {
        return lessons;
    }
}
