| # | LLD Problem Statement | Description / What Interviewers Expect |
|---|------------------------|-----------------------------------------|
| 1 | Cross-Platform UI Toolkit | Create families of UI widgets (Button, TextField, Dialog) for Windows, Mac, Linux, Android, Web. |
| 2 | Theme Engine (Dark / Light / Custom Themes) | Each theme provides its own family of components: buttons, checkboxes, cards, scrollbars. |
| 3 | Vehicle Parts Factory | Each vehicle type (Electric, Petrol, Diesel) produces its own engine, dashboard, and components. |
| 4 | Cloud Provider SDK Factory | AWS, GCP, Azure each produce families of services: Storage, Compute, Messaging, Monitoring. |
| 5 | Furniture Store Catalog | Each furniture style (Modern, Vintage, Victorian) provides Chair, Sofa, Table, Bed. |
| 6 | Notification System with Channel Families | Different customer types (Retail/Wholesale/Premium) have families of templates + formatters. |
| 7 | Game Worlds (Ice / Forest / Desert) | Each world has its own family of Enemies, Weapons, Obstacles, Visual Effects. |
| 8 | Database Driver Factory | Each DB (MySQL, Postgres, Oracle, SQL Server) provides its own Connection, QueryBuilder, Parser. |
| 9 | Report Export System | Each export type (PDF/Excel/CSV) provides header, body, footer formatter + stylesheet. |
|10 | Cross-Platform Payment Gateway Factory | Each region (India/US/EU) provides validator, processor, refund handler, transaction builder. |
|11 | Factory Method vs Abstract Factory | Compare responsibility, object family creation, and extensibility. |
|12 | Abstract Factory vs Builder Pattern | Explain use cases and differences in object construction. |
|13 | When NOT to use Abstract Factory | Over-engineering scenarios or when product families don’t vary together. |
|14 | Extending Product Families | How to add new families without modifying existing client code (OCP). |
|15 | Real Examples in Java/Spring | Examples: Spring BeanFactory, Hibernate Dialect Factory, JDBC Driver factories. |

                          +--------------------+
                          |     UIFactory      |  <<interface>>
                          | +createButton()    |
                          | +createTextField() |
                          | +createDialog()    |
                          +---------+----------+
                                    ^
                +-------------------+-------------------+
                |                   |                   |
        +---------------+   +---------------+   +---------------+
        | WindowsFactory|   |   MacFactory  |   |  LinuxFactory |
        +---------------+   +---------------+   +---------------+
           /     |     \        /     |     \        /     |     \
          /      |      \      /      |      \      /      |      \
    +--------+ +-----------+ +--------+ +-----------+ +--------+ +-----------+
    |Button  | |TextField  | |Button  | |TextField  | |Button  | |TextField  |
    |(iface) | |(iface)    | |(iface) | |(iface)    | |(iface) | |(iface)    |
    +---+----+ +----+------+ +---+----+ +----+------+ +---+----+ +----+------+
    ^            ^          ^            ^          ^            ^
    |            |          |            |          |            |
    +--------+  +-----------+ +--------+  +-----------+ +--------+  +-----------+
    |Windows |  |Windows    | |Mac     |  |Mac        | |Linux   |  |Linux      |
    |Button  |  |TextField  | |Button  |  |TextField  | |Button  |  |TextField  |
    +--------+  +-----------+ +--------+  +-----------+ +--------+  +-----------+
