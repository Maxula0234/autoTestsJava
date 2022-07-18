package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class MainPageTest {

    @Driver()
    WebDriver driver;


    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickLoginOrReg()
                .inputLogin("vladoladvlad@gtest.com")
                .inputPassword("veryStrongPassword111!")
                .enterLogIn()
                .checkLogin();
    }

}
