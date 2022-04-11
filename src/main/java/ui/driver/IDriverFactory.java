package ui.driver;

import ui.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {

    WebDriver getDriver() throws DriverTypeNotSupported;

}
