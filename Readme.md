1. User -> OrderService -> Order Created
2. User -> PaymentService
    Create Payment Link
    PaymentService -> OrderService to get order details - amount, etc
    Create Payment Link for that order
3. User -> Open Payment Link -> Make Payment
    Redirect user to callback url
4. CallBack URL -> PaymentService  -> OrderService to update order status
5. PaymentGateway -> PaymentService - webhookUrl 


PaymentService API
    - Create Payment Link
    - Get Payment Status
    - Handle Webhook Event