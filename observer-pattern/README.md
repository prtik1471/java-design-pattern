## Most commom use cases asked for Observer Pattern

| #      | Use Case                                        | Description / Real Example                                                                                                                           |
| ------ | ----------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| **1**  | **GUI Frameworks (Button Click Listeners)**     | Classic example — multiple listeners observe a button click event (`ActionListener` in Java Swing or AWT).                                           |
| **2**  | **Stock Market Price Tracker**                  | When a stock price changes, all investors (observers) subscribed to that stock are notified. Common example for conceptual clarity.                  |
| **3**  | **Weather Station / Temperature Monitor**       | Devices or apps (observers) update their display whenever the central weather data changes. Very common textbook + interview case.                   |
| **4**  | **Chat Application or Messaging System**        | Users in a chatroom get notified when a new message arrives. Each connected client observes the chatroom topic.                                      |
| **5**  | **Notification Systems / Event Bus**            | When an event occurs (new order, product back in stock), all interested subscribers are notified — like in e-commerce or microservices.              |
| **6**  | **Logging Frameworks**                          | When an event occurs, all registered loggers (console, file, cloud) are notified to log the message. Often used in logging library design questions. |
| **7**  | **Real-time Dashboard Updates**                 | In analytics dashboards (e.g., stock tickers, system metrics), multiple visual components observe live data streams.                                 |
| **8**  | **Social Media Feed / Follower Updates**        | When a user posts something, all followers (observers) get notified. Often asked as "Design Twitter/Facebook notification system".                   |
| **9**  | **Build Systems (e.g., Gradle, Maven)**         | Different build tasks can observe a dependency or build phase event — when one completes, others react.                                              |
| **10** | **Distributed Event Systems (Kafka, RabbitMQ)** | Subscribers consume messages published to a topic — real-world implementation of Observer in distributed systems.                                    |
| **11** | **File Watchers / Directory Monitoring**        | When a file changes, all registered handlers (backup service, indexing service, UI update) are notified.                                             |
| **12** | **Game Engines (Event Triggers)**               | Game objects listen to events (like collision, score updates, health changes) and react dynamically.                                                 |
