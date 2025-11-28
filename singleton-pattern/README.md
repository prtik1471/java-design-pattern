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
## Interview-ready recommendation

* If nothing prevents using enum: use the enum singleton. It's short, safe, and robust.

* If enum isn't suitable (need subclassing, complex initialization, or specific inheritance):

* Use a final class with private constructor.

* Use eager init or holder idiom for thread-safe lazy init.

* Add constructor guard, override clone() to throw, implement readResolve(), and mark final.

* Consider classloader and reflection attack vectors when designing for hostile environments.