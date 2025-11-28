package org.undoRedoTextEditor;

public class Application {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Invoker invoker = new Invoker(20);

        invoker.executeCommand(new InsertCommand(editor, 0, "Hello"));
        invoker.executeCommand(new InsertCommand(editor, 6, "World"));
        invoker.executeCommand(new InsertCommand(editor, 11, " ! "));

        System.out.println("after inserting all: " + editor.getText());
        System.out.println("undo");
        invoker.undo();
        System.out.println("text : " + editor.getText());
        invoker.undo();
        System.out.println("text : " + editor.getText());
        invoker.undo();
        System.out.println("text : " + editor.getText());
    }
}
