package pages.categories;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

@UrlPrefix("/categories/programming/")
public class ProgrammingCategoriesPage extends BasePage<ProgrammingCategoriesPage> {

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public ProgrammingCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLessons() {
        return lessons;
    }
}
