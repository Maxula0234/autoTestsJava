package pages;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/lessons")
public class Lessons extends BasePage<Lessons> {

    @FindBy(xpath = "//div[@data-elem-type=\"button\"]/div[@class='tn-atom' and contains(text(),'Специализация')]")
    private WebElement spec;

    @FindBy(xpath = "//div[@field='tn_text_1613568838724']")
    private WebElement startDate;

    public Lessons(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void specIsDisplayed() {
        assertThat(spec.isDisplayed()).as("Элемент не виден на странице").isTrue();
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public void checkLessonsPage() {
        assertThat(getTitlePage()).as("Страница не отображена").isNotEmpty();
    }
}
