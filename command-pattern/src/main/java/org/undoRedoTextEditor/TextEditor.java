package org.undoRedoTextEditor;

//Receiver
public class TextEditor {
    private final StringBuilder content = new StringBuilder();
    //cursor position : setting 0 at start
    private int cursor = 0;

    //actions
    public void insert(int pos, String text) {
        if(pos < 0 || pos > content.length()) {
            pos = content.length();
        }
        content.insert(pos, text);
        cursor = pos + text.length();
    }

    public String delete(int pos, int length) {
        if(pos < 0) pos = 0;
        if(pos >= content.length()) return "";

        int end = Math.min(pos + length, content.length());
        String deleted = content.substring(pos, end);
        content.delete(pos, end);
        cursor = pos;
        return deleted;
    }

    public String getText() {
        return content.toString();
    }
    public int getPos() {
        return cursor;
    }
    public void setCursor(int cursor) {
        if(cursor < 0) cursor = 0;
        if(cursor > content.length()) cursor = content.length();

        this.cursor = cursor;
    }

}
