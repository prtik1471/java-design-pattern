package org.undoRedoTextEditor;

class InsertCommand implements Command {
    private final TextEditor editor;
    private final int pos;
    private final String text;

    public InsertCommand(TextEditor editor, int pos, String text) {
        this.editor = editor;
        this.pos = pos;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.insert(pos, text);
    }

    @Override
    public void unExecute() {
        editor.delete(pos, text.length());
    }

    @Override
    public String toString() {
        return "Insert('" + text + "' @ " + pos + ")";
    }
}