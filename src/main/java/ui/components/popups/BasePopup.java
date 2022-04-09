package ui.components.popups;

import ui.actions.CommonActions;
import org.openqa.selenium.WebDriver;

public abstract class BasePopup<T> extends CommonActions<T> implements IPopup<T> {

    public BasePopup(WebDriver driver) {
        super(driver);
    }
}
