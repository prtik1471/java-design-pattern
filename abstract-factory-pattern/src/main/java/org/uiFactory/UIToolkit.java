package org.uiFactory;

import org.uiFactory.button.Button;
import org.uiFactory.textField.TextField;

public class UIToolkit {
    Button button;
    TextField textField;

    public void setButton(Button button) {
        this.button = button;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getButton() {
        return button;
    }

    public TextField getTextField() {
        return textField;
    }
}
