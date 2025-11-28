| # | LLD Problem Statement / System | Why Adapter Pattern Is Used |
|---|-------------------------------|------------------------------|
| 1 | Integrate a new Payment Gateway with an existing Payment Service | Your app expects `processPayment()`, new gateway provides `makeCharge()`. |
| 2 | Design a Logging System that supports multiple log providers | Each provider has different API signatures → adapter standardizes them. |
| 3 | Build a Notification Service (Email/SMS/Push) over 3rd-party APIs | Twilio/SendGrid etc. use different request structures → adapter hides differences. |
| 4 | Design a Media Player that supports multiple audio/video formats | Player expects `play()`, formats have different decoders. |
| 5 | Build a File Reader that supports XML/CSV/JSON via multiple libraries | Each library has its own parse method → adapter unifies into `read()`. |
| 6 | Integrate Legacy Authentication with a new Auth System | Legacy system uses `authUser()`, client expects `login()`. |
| 7 | Design a Map Service combining Google Maps, Apple Maps, MapBox | Each vendor has different APIs → adapters provide consistent `getRoute()` etc. |
| 8 | Create a Unified Search API for Elasticsearch, Solr, DB | Each search provider exposes different query formats. |
| 9 | Implement External Billing/Invoice System integration | Your system expects `generateInvoice()`, vendor exposes `createDocument()`. |
|10 | Design Multi-Database Support (MySQL, Oracle, Postgres) | Each JDBC driver exposes slightly different APIs → adapter provides unified interface. |
|11 | Cloud Storage Abstraction (AWS S3, Azure Blob, GCP Storage) | Clients expect `upload()`, cloud SDKs use different methods like `putObject()`. |
|12 | Third-party Analytics SDK integration | App expects `trackEvent()`, SDK offers `send()` or `logEvent()`. |
|13 | Build a Printer Driver System | Printer drivers have vendor-specific APIs → adapter exposes `print()`. |
|14 | Payment Wallet Aggregator (Paytm, PhonePe, Google Pay) | Each wallet API defines different functions for pay/refund/verify. |
|15 | Social Login Unification (Google/Facebook/GitHub OAuth) | Normalize different token exchange APIs into a common `authenticate()` method. |
|16 | Translation Service with Multiple Providers | Unify APIs like Google Translate, AWS Translate, DeepL. |
|17 | Unified SMS Gateway | Each SMS provider uses different payload structures → adapter normalizes to `sendSMS()`. |
|18 | IoT Device Protocol Normalization | Devices speak different protocols (MQTT, HTTP, ZigBee) → adapter normalizes read/write commands. |
|19 | Payment POS Terminal Integration | Vendor APIs differ, but POS system expects a standard interface. |
|20 | Build a Universal Charger / Plug Adapter (physical analogy) | Classic example often used in interviews to explain intent. |

### UML for logger adapter with factory for multiple types of adapter

                           +---------------------+
                           |       Logger        |  <<interface>>
                           |---------------------|
                           | + info(msg)         |
                           | + warn(msg)         |
                           | + error(msg)        |
                           | + debug(msg)        |
                           | + log(level,msg)    |
                           +----------^----------+
                                      |
               +----------------------+----------------------+
               |                      |                      |
    +------------------+   +--------------------+  +---------------------+
    | ConsoleAdapter   |   |   Log4jAdapter     |  |    CloudAdapter     |
    |------------------|   |--------------------|  |---------------------|
    | - consoleLogger  |   | - log4jLogger      |  | - cloudClient       |
    | + info(..)       |   | + info(..)         |  | + info(..)          |
    | + warn(..)       |   | + warn(..)         |  | + warn(..)          |
    | + error(..)      |   | + error(..)        |  | + error(..)         |
    | + debug(..)      |   | + debug(..)        |  | + debug(..)         |
    +--------+---------+   +--------+-----------+  +----------+----------+
    |                      |                         |
    | uses/adapts          | uses/adapts             | uses/adapts
    v                      v                         v
    +---------------+     +----------------------+   +--------------------+
    | ConsoleLogger  |     | org.apache.log4j.Logger | | CloudLoggingClient |
    | + print(msg)   |     | + info/warn/error/debug | | + sendLog(payload) |
    +---------------+     +------------------------+   +--------------------+

    +------------------------+
    |     LoggerFactory      |
    |------------------------|
    | + getLogger(name):Logger|
    | + registerAdapter(...) |
    +-----------+------------+
    |
    v
    +---------+
    | AppClient |
    | -logger  |
    | +doWork()|
    +---------+
