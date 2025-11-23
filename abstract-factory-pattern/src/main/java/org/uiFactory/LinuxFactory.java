package org.uiFactory;

import org.uiFactory.button.Button;
import org.uiFactory.button.LinuxButton;
import org.uiFactory.textField.LinuxTextField;
import org.uiFactory.textField.TextField;

public class LinuxFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
