package org.undoRedoTextEditor;

public interface Command {
    void execute();
    void unExecute();
}
