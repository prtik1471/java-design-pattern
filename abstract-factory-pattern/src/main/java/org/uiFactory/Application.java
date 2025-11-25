package org.uiFactory;

public class Application {
    public static void main(String[] args) {
        UIToolkit uiToolkit = new UIToolkit();
        createUIToolkit(FactoryMaker.FactoryType.LINUX, uiToolkit);
        System.out.println(uiToolkit.getButton().getDescription());
        System.out.println(uiToolkit.getTextField().getDescription());
        // mac now
        createUIToolkit(FactoryMaker.FactoryType.MAC, uiToolkit);
        System.out.println(uiToolkit.getButton().getDescription());
        System.out.println(uiToolkit.getTextField().getDescription());
    }

    public static void createUIToolkit(FactoryMaker.FactoryType type, UIToolkit uiToolkit) {
        final UIFactory uiFactory = FactoryMaker.makeFactory(type);
        uiToolkit.setButton(uiFactory.createButton());
        uiToolkit.setTextField(uiFactory.createTextField());
    }
}
