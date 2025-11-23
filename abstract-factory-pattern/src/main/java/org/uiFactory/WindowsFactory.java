package org.uiFactory;

import org.uiFactory.button.Button;
import org.uiFactory.button.WindowsButton;
import org.uiFactory.textField.TextField;
import org.uiFactory.textField.WindowsTextField;

public class WindowsFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
