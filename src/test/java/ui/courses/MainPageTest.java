package ui.courses;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.annotations.Driver;
import ui.extensions.UIExtension;
import ui.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(UIExtension.class)
public class MainPageTest {

    @Driver()
    WebDriver driver;

    @Test
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickReg();
        String titlePage = mainPage.getTitlePage();
        assertThat(titlePage).isNotEmpty();
    }

    @Test
    @Description("Авторизация")
    public void loginTest() {
        String login = "vladoladvlad@gtest.com";
        String password = "veryStrongPassword111!";

        MainPage mainPage = new MainPage(driver)
                .open()
                .clickReg()
                .enterName(login)
                .enterPassword(password)
                .clickButtonEnter();

        mainPage.checkAuthClient("Владимир");
    }

}
