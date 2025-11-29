| # | LLD Problem Statement / System | Why Facade Pattern Fits |
|---|-------------------------------|--------------------------|
| 1 | Design a Payment Processing Workflow | Payment needs multiple subsystems: validation, fraud check, gateway API, notifications → Facade simplifies to `processPayment()`. |
| 2 | Design an Order Management System | Internally calls inventory, billing, shipping, tracking → exposed as `placeOrder()`. |
| 3 | Design a Hotel Booking System / Travel Aggregator | Wraps flights, hotels, payments, notifications into a single `bookTrip()` API. |
| 4 | Design a Movie Ticket Booking System | Coordinates seat selection, payment, confirmation, ticket generation → single facade for UI. |
| 5 | Design an Amazon-like Checkout Flow | Facade combines cart, coupons, payment, wallet, shipping, inventory. |
| 6 | Design an Email Sending System | Internally uses templates, SMTP client, authentication, formatting → simple `sendEmail()`. |
| 7 | Design a Notification Service (Email/SMS/Push) | Multiple providers & flows hidden under `sendNotification()`. |
| 8 | Design a File Conversion/Media Conversion System | Wraps codec, compression, file reader/writer → exposed as `convert(file, type)`. |
| 9 | Design a Home Automation System (Smart Home) | Wraps devices: lights, fans, AC, locks → single `turnOffAll()` / `nightMode()`. |
|10 | Design a Video Streaming Platform | Wraps CDN, codec loader, buffer, DRM → simplified `play(url)`. |
|11 | Design a Loan Application System | Coordinates eligibility check, credit score, document scan, KYC → facade → `applyLoan()`. |
|12 | Design a CRM/Lead Onboarding System | Pulls data from multiple microservices → facade hides complexity from UI. |
|13 | Design a Build/Deployment Pipeline | Wraps compilation, testing, packaging, artifact upload → `buildAndDeploy()`. |
|14 | Design a Social Media Post Scheduler | Internally connects to FB/IG/Twitter APIs → facade exposes `publish(post)`. |
|15 | Design a Search Service Aggregator | Combines ES, DB, cache, ranking into `search(query)`. |
|16 | Design a Messaging/Chat API | Wraps encryption, routing, delivery receipts → simplified `sendMessage()`. |
|17 | Design a Hospital Appointment Booking System | Wrangles doctor availability, records, billing, reminders → `bookAppointment()`. |
|18 | Design a Fraud Detection Workflow | Wraps multiple ML models + rules systems → single `evaluate(transaction)`. |
|19 | Design an Authentication/Authorization Module | Hides steps: hashing, DB lookup, session creation → façade `login(username, password)`. |
|20 | Design a Cloud Resource Manager (AWS/GCP/Azure) | Calls compute, network, IAM APIs → single `createVM()` or `deployApp()`. |


### UML for payment processing

                         +-------------------------+
                         |     PaymentFacade       |
                         |-------------------------|
                         | +processPayment(order,  |
                         |   paymentInfo):PaymentResult
                         | +refund(paymentId):RefundResult
                         +-----------+-------------+
                                     |
            +------------------------+-------------------------+
            |                        |                         |
    +------------------+    +---------------------+     +------------------+
    | ValidationService|    | FraudCheckService   |     | InventoryService |
    |------------------|    |---------------------|     |------------------|
    | +validateOrder() |    | +assess(...)        |     | +reserveItems()  |
    | +validatePayment |    |                     |     | +releaseItems()  |
    +------------------+    +---------------------+     +------------------+
    |
    |
    +-------+-------+
    | PaymentGateway |
    |   Manager      |
    |--------------- |
    | +executePayment|
    | +refund(...)   |
    +-------+--------+
    |
    delegates to / adapts
    |
    +---------+---------+------------+
    | Stripe  | PayPal   |  UPI      |
    | Gateway | Gateway  | Gateway   |
    +---------+---------+----------- +
    | charge()| charge() | charge()  |
    | refund()| refund() | refund()  |
    +--------------------------------+

    Other collaborators:
    +----------------+   +---------------+  +----------+
    | Notification   |   | ReceiptService|  | Logger   |
    | Service        |   |               |  |          |
    | notifySuccess()|   | generateReceipt|  | info()/..|
    +----------------+   +---------------+  +----------+

### Short Usage / Flow (to add under the UML)

* Client calls PaymentFacade.processPayment(order, paymentInfo).
* Facade validates the request via ValidationService.
* Facade calls FraudCheckService.assess(...).
* Facade reserves items via InventoryService.
* Facade delegates to PaymentGatewayManager.executePayment(...) (which chooses the concrete gateway adapter like StripeGateway or PayPalGateway).
* On success: ReceiptService.generateReceipt(...) and NotificationService.notifyPaymentSuccess(...).
* On failure: InventoryService.releaseItems(...) and NotificationService.notifyPaymentFailure(...).
* PaymentFacade returns a PaymentResult to the client.