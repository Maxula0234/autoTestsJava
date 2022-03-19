package driver;

import driver.impl.ChromeWebDriver;
import driver.impl.FireFoxWebDriver;
import driver.impl.OperaWebDriver;
import exceptions.DriverTypeNotSupported;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory {

    private String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);

    @Override
    public EventFiringWebDriver getDriver() {
        switch (this.browserType) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
            }
            case "safari": {
                return new EventFiringWebDriver(new SafariDriver());
            }
            case "firefox": {
                return new EventFiringWebDriver(new FireFoxWebDriver().newDriver());
            }
            case "opera": {
                return new EventFiringWebDriver(new OperaWebDriver().newDriver());
            }
            default:
                try {
                    throw new DriverTypeNotSupported(this.browserType);
                } catch (DriverTypeNotSupported ex) {
                    ex.printStackTrace();
                    return null;
                }
        }
    }
}
