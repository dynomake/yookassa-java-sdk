package me.dynomake.yookassa;

import me.dynomake.yookassa.exception.BadRequestException;
import me.dynomake.yookassa.exception.UnspecifiedShopInformation;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Confirmation;
import me.dynomake.yookassa.model.Payment;
import me.dynomake.yookassa.model.request.PaymentRequest;
import me.dynomake.yookassa.model.request.receipt.Receipt;
import me.dynomake.yookassa.model.request.receipt.ReceiptCustomer;
import me.dynomake.yookassa.model.request.receipt.ReceiptItem;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SmallTest {

    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) throws UnspecifiedShopInformation, BadRequestException, IOException {
        Yookassa yookassa = Yookassa.initialize(4, "TOKEN");
        Payment payment = yookassa.createPayment(PaymentRequest.builder()
                .amount(new Amount("2.00", "RUB"))

                .description("Это тестовый платеж!")
                        .receipt(Receipt.builder()
                                .customer(ReceiptCustomer.builder().email("dynomake@gmail.com").build())
                                .items(Arrays.asList(ReceiptItem.builder()
                                                .amount(new Amount("2.00", "RUB"))
                                                .quantity(1)
                                                .subject("service")
                                                .paymentMode("full_payment")
                                                .vat(1)
                                                .description("тестовый товар").build()))
                                .build())
                .savePaymentMethod(true)
                        .confirmation(Confirmation.builder()
                                .type("redirect")
                                .returnUrl("https://dynomake.space")
                                .build())
                .build());

        System.out.println("bill link:" + payment.getConfirmation().getConfirmationUrl());
    }
}
