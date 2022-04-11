package ui.pages.services;

import ui.components.contacts.SocialMediaComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ContactsPage extends BasePage<ContactsPage> {
    public SocialMediaComponent socialMediaComponent;
    @FindBy(xpath = "//div[contains(@class,'kfHYcg')]/div[text()='Контакты']")
    private WebElement title;
    @FindBy(xpath = "//div[text()='Реквизиты']/following-sibling::div")
    private WebElement requisites;

    public ContactsPage(WebDriver driver) {
        super(driver);
        socialMediaComponent = new SocialMediaComponent(driver);
    }

    @Step("Проверим отображение реквизитов на странице 'Контакты'")
    public void checkRequisites(ContactsPage contactsPage) {
        Map<String, String> stringStringMap = Arrays.stream(contactsPage.requisites.getText().split("\n"))
                .map(str -> str.split("^.\\s.$", 0))
                .filter(f -> f[0].length() > 0)
                .map(f -> f[0].split("\\s",2))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));


        assertAll(
                () -> assertThat(stringStringMap.get("ООО")).contains("«Отус онлайн-образование»"),
                () -> assertThat(stringStringMap.get("ИНН")).contains("9705100963"),
                () -> assertThat(stringStringMap.get("КПП")).contains("771401001"),
                () -> assertThat(stringStringMap.get("ОГРН")).contains("1177746618576"),
                () -> assertThat(stringStringMap.get("ОКПО")).contains("16102045"),
                () -> assertThat(stringStringMap.get("ОКАТО")).contains("4528650000"),
                () -> assertThat(stringStringMap.get("АО")).contains("«АЛЬФА-БАНК»"),
                () -> assertThat(stringStringMap.get("Р/С")).contains("40702810601300013780"),
                () -> assertThat(stringStringMap.get("К/С")).contains("30101810200000000593"),
                () -> assertThat(stringStringMap.get("БИК")).contains("044525593")
        );
    }
}
