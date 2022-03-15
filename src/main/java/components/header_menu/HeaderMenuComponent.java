package components.header_menu;

import annotations.Component;
import components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Component("//div[@class='container container-header2']")
public class HeaderMenuComponent extends BaseComponent<HeaderMenuComponent> {

    @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//p[normalize-space(text())='Курсы']")
    public WebElement coursesHeaderMenu;

    @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//a[@title='Тестирование']")
    public WebElement testingHeaderSubMenuItem;

    @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//a[@title='Программирование']")
    public WebElement programmingHeaderSubMenuItem;

    @FindBy(xpath = "//a[contains(@title,'Тестирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    public WebElement testingSubMenuDpTriger;

    @FindBy(xpath = "//a[contains(@title,'Программирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    public WebElement programmingSubMenuDpTriger;

    @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//a[@title='Python QA Engineer']")
    public WebElement pythonCoursesElement;

    @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//a[@title='Kotlin Backend Developer']")
    public WebElement kotlinBackendCoursesElement;

    public HeaderMenuComponent(WebDriver webDriver) {
        super(webDriver);
    }

}
