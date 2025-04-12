## | `Yookassa Java SDK - Usage:`
*You can found full example-code in:* [LINK](https://github.com/dynomake/yookassa-java-sdk/tree/master/src/test/java/me/dynomake/yookassa)

First initialize the instance of Yookassa:
```java
Yookassa yookassa = Yookassa
        .initialize(YOU_SHOP_IDENTIFIER, YOU_SHOP_TOKEN);
```

Cool! Now you can work with the cashier, for example, create a payment, and output a link to the payment in the console:

```java
Payment payment = yookassa.createPayment(PaymentRequest.builder()
        .amount(new Amount("2.00", "RUB"))

        .description("This is a test payment!")
        .receipt(Receipt.builder()
                .customer(ReceiptCustomer.builder().email("dynomake@gmail.com").build())
                .items(Arrays.asList(ReceiptItem.builder()
                        .amount(new Amount("2.00", "RUB"))
                        .quantity(1)
                        .subject("service")
                        .paymentMode("full_payment")
                        .vat(1)
                        .description("Test product").build()))
                .build())
        .savePaymentMethod(true)
        .confirmation(Confirmation.builder()
                .type("redirect")
                .returnUrl("https://dynomake.space")
                .build())
        .build());

System.out.println("bill link: " + payment.getConfirmation().getConfirmationUrl());
```

Okay, just check it out.