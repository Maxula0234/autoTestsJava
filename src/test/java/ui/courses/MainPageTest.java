package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(UIExtension.class)
public class MainPageTest {

    @Driver()
    WebDriver driver;

    @Test
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .reg.click();
        String titlePage = mainPage.getTitlePage();
        assertThat(titlePage).isNotEmpty();
    }

}
