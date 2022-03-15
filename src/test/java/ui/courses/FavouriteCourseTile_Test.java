package ui.courses;

import annotations.Driver;
import annotations.WaitDriver;
import components.FavouriteCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class FavouriteCourseTile_Test {

    @Driver
    public WebDriver driver;

    @WaitDriver()
    public WebDriverWait webDriverWait;


    @Test
    public void click_favourite_course_tile() {
        new MainPage(driver).open();

        new FavouriteCourses(driver)
                .clickLessonItem()
                .getPageTitle();
    }

    @Test
    public void case1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("DSD", Keys.RETURN);

        Actions actions = new Actions(driver);
        actions
                .sendKeys("selenium")
                .click()
                .pause(100)
                .sendKeys(Keys.RETURN)
                .build()
                .perform();

        actions.moveToElement(search).perform(); // Наведем на элемент

        webDriverWait.until(ExpectedConditions.visibilityOf(search));
    }

    @Test
    public void case2() {
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("DSD", Keys.RETURN);
    }


}
