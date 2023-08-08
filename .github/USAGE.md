## | `Yookassa Java SDK - Usage:`
*You can found full example-code in:* [LINK](https://github.com/dynomake/yookassa-java-sdk/tree/master/src/test/java/me/dynomake/yookassa)

First initialize the instance of Yookassa:
```java
Yookassa yookassa = Yookassa
        .initialize(YOU_SHOP_IDENTIFIER, YOU_SHOP_TOKEN);
```

Cool! Now you can work with the cashier, for example, create a payment, and output a link to the payment in the console:

```java
Payment payment = yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "EUR"), "Test Payment", "https://vpn.dynomake.me");
System.out.println("bill link:" + payment.confirmation.confirmation_url);
```

Okay, just check it out.