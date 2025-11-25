                   +-----------------------------+
                   |           Logger            |
                   +-----------------------------+
                   | - static instance: Logger   |
                   | - Logger()                  |  (private constructor)
                   +-----------------------------+
                   | + getInstance(): Logger     |
                   | + log(message: String)      |
                   | + info(message: String)     |
                   | + error(message: String)    |
                   +-----------------------------+

        Notes:
        - Singleton ensures only ONE Logger instance exists.
        - Global access via getInstance().
        - Centralized logging avoids file/console conflicts.

* Always declare singleton class final. there can be multiple instances created using subclasses