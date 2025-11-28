| # | LLD Problem Statement / System | Why It Uses Command Pattern |
|---|--------------------------------|-------------------------------|
| 1 | Design Undo/Redo Functionality in a Text Editor | Each user action (type, delete, format) becomes a Command; supports undo/redo stacks. |
| 2 | Design Remote Control for Home Automation | Each button press maps to a Command (LightOn, LightOff, ACOn, FanSpeedUp). |
| 3 | Design a Macro Recorder / Playback System | Commands can be recorded, stored, and executed later. |
| 4 | Design a Job Scheduler / Task Queue | Jobs are encapsulated as Command objects and scheduled/executed independently. |
| 5 | Design a GUI Button / Menu Action System | Button click executes a Command without knowing receiver logic. |
| 6 | Design an Order Processing Pipeline | Each operation (validate, charge payment, notify user) becomes a Command. |
| 7 | Design a Transaction System with Rollback | Each step is a Command with execute() and undo() for compensation. |
| 8 | Design a File Operations Manager (Copy/Move/Delete) | Each operation is a Command, enabling history + undo. |
| 9 | Design a Drawing Application (Paint, Illustrator) | Every stroke/shape create/delete/update is a Command; supports undo/redo. |
|10 | Design a Workflow / Pipeline Engine | Each workflow step is a Command executed in sequence or conditionally. |
|11 | Design a ChatBot / Assistant Command Invoker | Commands represent actions like SendMessage, FetchData, OpenApp. |
|12 | Design a Multi-level Menu System (like VSCode/IntelliJ) | Menu items map to commands decoupled from UI. |
|13 | Design a Robotic Controller (Move, Pick, Drop) | Each robot action is a Command that can be queued/executed/undone. |
|14 | Design Request Handling System (Queue-based) | Each request becomes a Command dispatched to handlers. |
|15 | Design Game Character Actions (Attack, Jump, MoveLeft) | Replayable actions stored as Command objects. |

## Why these show up in interviews?

    Each scenario:

* involves decoupling action invocation from execution

* requires queuing, scheduling, recording, or undo/redo

* needs a structure where commands must be independent objects

* is naturally testable for LLD fundamentals

* Command Pattern = When actions must be treated as objects.

                   +-----------------------+
                   |       Command         |
                   |-----------------------|
                   | + execute()           |
                   | + undo()              |
                   +-----------^-----------+
                               |
               +---------------+-----------------+
               |                                 |
      +-----------------------+         +-------------------------+
      |     InsertCommand     |         |      DeleteCommand      |
      |-----------------------|         |--------------------------|
      | - editor: TextEditor  |         | - editor: TextEditor     |
      | - pos: int            |         | - pos: int               |
      | - text: String        |         | - length: int            |
      |                       |         | - deletedText: String    |
      | + execute()           |         | + execute()              |
      | + undo()              |         | + undo()                 |
      +-----------+-----------+         +------------+-------------+
      |                                   
      | operates on                        
      v                                    
      +---------------------------+                  
      |        TextEditor         |                  
      |---------------------------|                  
      | - content: StringBuilder  |                  
      | - cursor: int             |                  
      | + insert(pos,text)        |                  
      | + delete(pos,len)         |                  
      | + getText()               |                  
      | + setCursor(pos)          |                  
      | + getCursor()             |                  
      +-------------+-------------+                  
      ^                                
      | executes                       
      |                                
      +-------------+-------------+                  
      |        CommandManager     |                  
      |---------------------------|                  
      | - undoStack: Stack        |                  
      | - redoStack: Stack        |                  
      | + executeCommand(cmd)     |                  
      | + undo()                  |                  
      | + redo()                  |                  
      | + canUndo()               |                  
      | + canRedo()               |                  
      +---------------------------+                  
