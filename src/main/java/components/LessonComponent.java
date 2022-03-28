package components;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Component("//div[@class='lessons__new-item-container']")
public class LessonComponent extends BaseComponent<LessonComponent> {

    @FindBy(xpath = "//div[@class='lessons__new-item-container']")
    List<LessonComponent> list;
    @FindBy(xpath = ".//div[@class='lessons__new-item-time']")
    private String startDate;
    @FindBy(xpath = ".//div[contains(@class,'lessons__new-item-title_with-bg')]")
    private String nameLesson;

    public LessonComponent(WebDriver driver) {
        super(driver);
    }

}
