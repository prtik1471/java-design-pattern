package org.undoRedoTextEditor;

class DeleteCommand implements Command {
    private final TextEditor editor;
    private final int pos;
    private final int length;
    private String deletedText; // saved on execute for undo

    public DeleteCommand(TextEditor editor, int pos, int length) {
        this.editor = editor;
        this.pos = pos;
        this.length = length;
    }

    @Override
    public void execute() {
        deletedText = editor.delete(pos, length);
    }

    @Override
    public void unExecute() {
        if (deletedText != null && !deletedText.isEmpty()) {
            editor.insert(pos, deletedText);
        }
    }

    @Override
    public String toString() {
        return "Delete(len=" + length + " @ " + pos + ")";
    }
}

