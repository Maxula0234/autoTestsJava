package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@Slf4j
@ExtendWith(UIExtension.class)
public class ContactsTest {

    @Driver
    WebDriver driver;

    @Test
    @DisplayName("�������� ������� �� ��������� ��")
    public void goToVk() {
        new MainPage(driver)
                .open()
                .headerMenu1Component.goToContactsPage()
                .socialMediaComponent.goToVk()
                .checkVkPage("OTUS. ������-����������� | ���������");
    }

    @Test
    @DisplayName("�������� ������� �� ��������� OK")
    public void goToOk() {
        new MainPage(driver)
                .open()
                .headerMenu1Component.goToContactsPage()
                .socialMediaComponent.goToOk()
                .checkVkPage("OTUS. ������-�����������");
    }
}
