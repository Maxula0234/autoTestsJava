package ui.components.popups;

public interface IPopup<T> {
    T popupShouldBePresent();

    T popupShouldNotBePresent();
}
