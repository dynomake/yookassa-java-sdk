## | `Yookassa Java SDK - Usage:`
*You can found full example-code in:* [LINK](https://github.com/suuft/yookassa-java-sdk/tree/master/src/test/java/net/suuft/yookassa)

First initialize the instance of Yookassa:
```java
Yookassa yookassa = YookassaInitializer
        .initializeSdk(YOU_SHOP_IDENTIFIER, YOU_SHOP_TOKEN);
```

Cool! Now you can work with the cashier, for example, create a payment, and output a link to the payment in the console:

```java
Payment payment = yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "EUR"), "Test Payment", "https://suuft.naifu.works");
System.out.println("bill link:" + payment.confirmation.confirmation_url);
```

Okay, just check it out.