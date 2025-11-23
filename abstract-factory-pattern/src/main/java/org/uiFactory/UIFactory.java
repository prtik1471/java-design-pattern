package org.uiFactory;

import org.uiFactory.button.Button;
import org.uiFactory.textField.TextField;

public interface UIFactory {
    Button createButton();
    TextField createTextField();
}
