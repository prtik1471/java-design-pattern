package org.uiFactory;

import org.uiFactory.button.Button;
import org.uiFactory.button.MacButton;
import org.uiFactory.textField.MacTextField;
import org.uiFactory.textField.TextField;

public class MacFactory implements UIFactory{
    @Override
    public TextField createTextField() {
        return new MacTextField();
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }
}
