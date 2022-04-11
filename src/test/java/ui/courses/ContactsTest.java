package ui.courses;

import ui.annotations.Driver;
import ui.extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;

@Slf4j
@ExtendWith(UIExtension.class)
public class ContactsTest {

    @Driver
    WebDriver driver;

    @Test
    @DisplayName("Проверим переход на страничку ВК")
    public void goToVk() {
        new MainPage(driver)
                .open()
                .headerMenu1Component.goToContactsPage()
                .socialMediaComponent.goToVk()
                .checkVkPage("OTUS. Онлайн-образование | ВКонтакте");
    }

    @Test
    @DisplayName("Проверим переход на страничку OK")
    public void goToOk() {
        new MainPage(driver)
                .open()
                .headerMenu1Component.goToContactsPage()
                .socialMediaComponent.goToOk()
                .checkVkPage("OTUS. Онлайн-образование");
    }
}
