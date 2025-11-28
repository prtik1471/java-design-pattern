package org.undoRedoTextEditor;

import java.util.ArrayDeque;
import java.util.Deque;

public class Invoker {
    // to maintain undo and redo available operations
    private final Deque<Command> undoStack = new ArrayDeque<>();
    private final Deque<Command> redoStack = new ArrayDeque<>();
    private final int maxHistory;

    public Invoker() {
        this(100);
    }
    public Invoker(int maxHistory) {
        this.maxHistory = Math.max(10, maxHistory);
    }
    public void executeCommand(Command cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();

        if(undoStack.size() > maxHistory) {
            //drop oldest
            while(undoStack.size() > maxHistory) {
                undoStack.removeLast();
            }
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public void undo() {
        if (!canUndo()) return;
        Command cmd = undoStack.pop();
        cmd.unExecute();
        redoStack.push(cmd);
    }

    public void redo() {
        if (!canRedo()) return;
        Command cmd = redoStack.pop();
        cmd.execute();
        undoStack.push(cmd);
    }
}
