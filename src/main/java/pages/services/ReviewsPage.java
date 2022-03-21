package pages.services;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

@UrlPrefix("/reviews")
public class ReviewsPage extends BasePage<ReviewsPage> {
    @FindBy(xpath = "//a[contains(@href,'reviews')]//div[contains(@class,'fvPXwD')]")
    public List<WebElement> reviewsItems;

    public ReviewsPage(WebDriver driver) {
        super(driver);
    }
}
