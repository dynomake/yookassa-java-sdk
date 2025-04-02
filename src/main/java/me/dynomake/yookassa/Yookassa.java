package me.dynomake.yookassa;

import lombok.NonNull;
import me.dynomake.yookassa.event.YookassaEvent;
import me.dynomake.yookassa.exception.BadRequestException;
import me.dynomake.yookassa.exception.UnspecifiedShopInformation;
import me.dynomake.yookassa.implementation.RealYookassa;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Payment;
import me.dynomake.yookassa.model.Refund;
import me.dynomake.yookassa.model.Webhook;
import me.dynomake.yookassa.model.collecting.PaymentList;
import me.dynomake.yookassa.model.collecting.RefundList;
import me.dynomake.yookassa.model.collecting.WebhookList;
import me.dynomake.yookassa.model.request.PaymentRequest;
import me.dynomake.yookassa.model.request.RefundRequest;
import me.dynomake.yookassa.model.request.WebhookRequest;

import java.io.IOException;
import java.util.UUID;

public interface Yookassa {


    Payment createPayment(@NonNull PaymentRequest request) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Payment getPayment(@NonNull UUID paymentIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    // todo: limit, filters (status, date, paidDate..)
    PaymentList getPayments() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund createRefund(@NonNull RefundRequest request) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund getRefund(@NonNull UUID refundIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    RefundList getRefunds() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Webhook createWebhook(@NonNull WebhookRequest request) throws UnspecifiedShopInformation, BadRequestException, IOException;
    void deleteWebhook(@NonNull UUID webhookIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;
    WebhookList getWebhooks() throws UnspecifiedShopInformation, BadRequestException, IOException;


    static Yookassa initialize(int shopIdentifier, @NonNull String shopToken) {
        return new RealYookassa(shopIdentifier, shopToken);
    }
}
