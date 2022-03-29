package pages.services;

import components.contacts.SocialMediaComponent;
import helpers.HelperString;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ContactsPage extends BasePage<ContactsPage> {
    public SocialMediaComponent socialMediaComponent;
    @FindBy(xpath = "//div[contains(@class,'kfHYcg')]/div[text()='��������']")
    private WebElement title;
    @FindBy(xpath = "//div[text()='���������']/following-sibling::div")
    private WebElement requisites;

    public ContactsPage(WebDriver driver) {
        super(driver);
        socialMediaComponent = new SocialMediaComponent(driver);
    }

    @Step("�������� ����������� ���������� �� �������� '��������'")
    public void checkRequisites(ContactsPage contactsPage) {
        List<String> collect = Arrays.stream(contactsPage.requisites.getText().split("\n"))
                .collect(Collectors.toList());

        Map<String, String> stringStringMap = HelperString.parseStringToMap(collect);

        assertAll(
                () -> assertThat(stringStringMap.get("���")).contains("����� ������-�����������"),
                () -> assertThat(stringStringMap.get("���")).contains("9705100963"),
                () -> assertThat(stringStringMap.get("���")).contains("771401001"),
                () -> assertThat(stringStringMap.get("����")).contains("1177746618576"),
                () -> assertThat(stringStringMap.get("����")).contains("16102045"),
                () -> assertThat(stringStringMap.get("�����")).contains("4528650000"),
                () -> assertThat(stringStringMap.get("��")).contains("������-���ʻ"),
                () -> assertThat(stringStringMap.get("�/�")).contains("40702810601300013780"),
                () -> assertThat(stringStringMap.get("�/�")).contains("30101810200000000593"),
                () -> assertThat(stringStringMap.get("���")).contains("044525593")
        );
    }
}
