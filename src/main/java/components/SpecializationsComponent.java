package components;

import annotations.Component;
import constant.Month;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Lessons;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.fail;

@Component("//div[@class='container container-lessons']//div[@class='container-padding-bottom']")
public class SpecializationsComponent extends BaseComponent<SpecializationsComponent> {

    By dateLessonStart = By.xpath(".//div[@class='lessons__new-item-time']");

    @FindBy(xpath = "//div[@class='lessons']//a[@class='lessons__new-item lessons__new-item_big lessons__new-item_hovered']//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public SpecializationsComponent(WebDriver driver) {
        super(driver);
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

        actions.moveToElement(webElement)
                .click()
                .build()
                .perform();

        return new Lessons(driver);
    }

    public Lessons clickLessons(int numLesson) {
        lessons.get(numLesson).click();
        return new Lessons(driver);
    }

    public List<WebElement> getLessons() {
        return lessons;
    }

    private Date getStartDateCourse(WebElement lesson) {
        String[] s = lesson.findElement(dateLessonStart)
                .getText()
                .split(" ", 3);

        int month = 0;
        int num = 0;

        try {
            month = Month.findMonth(s[1]);
            num = Integer.parseInt(s[0]);
        } catch (Exception e) {
            return new Date(2099, 12, 1);
        }

        Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, num);
        return calendar.getTime();
    }

    public SpecializationsComponent sortedLessonByDate() {
        lessons = lessons.stream()
                .sorted((o1, o2) -> {
                    Date date1 = getStartDateCourse(o1);
                    Date date2 = getStartDateCourse(o2);

                    return date1.compareTo(date2);
                })
                .collect(Collectors.toList());
        return this;
    }
}
