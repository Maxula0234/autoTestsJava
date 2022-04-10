package ui.courses;

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

}
