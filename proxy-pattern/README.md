| # | LLD Problem Statement / System | Why Proxy Pattern Fits |
|---|-------------------------------|--------------------------|
| 1 | Design a File Access Manager / File Permissions Module | Proxy can enforce access control before allowing real file operations. |
| 2 | Design a Cache Layer for Expensive API Calls | Proxy wraps a remote API client and caches responses. |
| 3 | Implement Rate Limiter for an API / Service | Proxy intercepts requests and enforces limits before calling real service. |
| 4 | Design a Virtual Proxy for Large Image Loading (e.g., image viewer) | Proxy loads images lazily only when needed. |
| 5 | Design a Database Connection or ORM Wrapper | Proxy adds connection pooling, metrics, or lazy initialization. |
| 6 | Design a Payment Gateway Wrapper (security, retry, logging) | Proxy ensures security checks, rate limits, retries around gateway calls. |
| 7 | Implement an Authentication/Authorization Layer | Proxy checks authentication before invoking actual service. |
| 8 | Remote Service Access (RMI/GRPC/REST client wrapper) | Proxy hides network transport and provides local interface. |
| 9 | Design an API Gateway / Reverse Proxy | Proxy routes, validates, logs, throttles, then calls backend service. |
|10 | Lazy Initialization of Heavy Objects (Report generation, PDF builder) | Proxy delays object creation until first use. |
|11 | Protection Proxy for Admin Actions | Proxy ensures only privileged users can invoke certain methods. |
|12 | Design Logging Proxy for Services (AOP-like) | Proxy logs method calls before/after delegating to real object. |
|13 | Implement Transaction Proxy (like Spring AOP) | Proxy starts/commits/rolls back transactions around real calls. |
|14 | Retry + Circuit Breaker Wrapper around Microservice Calls | Proxy adds resilience features without modifying original service. |
|15 | Firewall / Access Filter | Proxy filters requests by IP, token, or rules before forwarding. |
|16 | Design a CDN caching layer | Proxy caches content from origin server, returns cached if available. |
|17 | Input Validation Wrapper | Proxy validates request payloads, then forwards to actual service. |
|18 | Analytics/Instrumentation Proxy | Proxy collects metrics before forwarding to service. |
|19 | Local Stub for Cloud Service (mock for testing) | Proxy simulates remote service to avoid hitting real backend. |
|20 | Smart Reference Proxy | Proxy counts references, manages shared resources automatically. |

* most used usecases used for access control, lazy loading and caching the expensive operations

                    +------------------------+
                    |    PaymentGateway      |  <<interface>>
                    |------------------------|
                    | + charge(request)      |
                    | + refund(transactionId)|
                    +-----------^------------+
                                |
               +----------------+----------------+
               |                                 |
        +-------------------+            +------------------------+
        | RealPaymentGateway|            | PaymentGatewayProxy    |
        |-------------------|            |------------------------|
        | + charge(...)     |            | - realGateway          |
        | + refund(...)     |            | - rateLimiter          |
        +-------------------+            | - logger               |
                                         | + charge(...)          |
                                         | + refund(...)          |
                                         +------------------------+
                                                          |
                                        +-----------------+----------------+
                                        |                 |                |
                                +-----------+      +----------+     +----------+
                                | RateLimiter|     | Logger   |     | Metrics  |
                                +-----------+      +----------+     +----------+
