## ☕ Decorator Pattern - Class Diagram (Coffee Shop Example)

                      +----------------------+
                      |      Beverage        |   ← Component interface
                      +----------------------+
                      | + getDescription()   |
                      | + cost()             |
                      +----------------------+
                                 ^
                                 |
                   +-------------+--------------+
                   |                            |
           +--------------------+    +--------------------+
           |     Espresso       |    |    HouseBlend      |   ← Concrete Components
           +--------------------+    +--------------------+
           | + getDescription() |    | + getDescription() |
           | + cost()           |    | + cost()           |
           +--------------------+    +--------------------+

                                 ^
                                 |
                         +-------------------+
                         |  AddOnDecorator   |   ← Abstract Decorator
                         +-------------------+
                         | - beverage: Beverage |
                         +-------------------+
                                 ^
                                 |
                   +-----------------------+
                   |   MilkDecorator       |
                   +-----------------------+
                   | + getDescription()    |
                   | + cost()              |
                   +-----------------------+
                   |   SugarDecorator      |
                   +-----------------------+
                   | + getDescription()    |
                   | + cost()              |
                   +-----------------------+
                   | WhippedCreamDecorator |
                   +-----------------------+
                   | + getDescription()    |
                   | + cost()              |
                   +-----------------------+
           
| #     | Use Case                              | Description                                                                |
| ----- | ------------------------------------- | -------------------------------------------------------------------------- |
| **1** | **Java I/O Streams**                  | `BufferedInputStream`, `DataInputStream` decorate a base `InputStream`.    |
| **2** | **Logging System**                    | Add decorators for timestamps, severity levels, or JSON formatting.        |
| **3** | **Web Filters / Middleware**          | Add authentication, logging, and compression around a request dynamically. |
| **4** | **Text Formatting**                   | Add bold, italics, underline decorations to a text component.              |
| **5** | **Encryption / Compression Wrappers** | Decorate a file stream with encryption, then compression layers.           |
