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

import java.io.IOException;
import java.util.UUID;

public interface Yookassa {

    Payment createPayment(@NonNull Amount amount, @NonNull String description, @NonNull String redirectUrl) throws UnspecifiedShopInformation, BadRequestException, IOException;

    // payment types: https://yookassa.ru/developers/payment-acceptance/getting-started/payment-methods#all
    Payment createPayment(@NonNull String type, @NonNull boolean saveMethod, @NonNull Amount amount, @NonNull String description, @NonNull String redirectUrl) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Payment createRecurrentPayment(@NonNull UUID methodId, @NonNull Amount amount, @NonNull String description) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Payment getPayment(@NonNull UUID paymentIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    // todo: limit, filters (status, date, paidDate..)
    PaymentList getPayments() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund createRefund(@NonNull UUID paymentIdentifier, @NonNull Amount amount) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund getRefund(@NonNull UUID refundIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    RefundList getRefunds() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Webhook createWebhook(@NonNull YookassaEvent event, @NonNull String url) throws UnspecifiedShopInformation, BadRequestException, IOException;
    void deleteWebhook(@NonNull UUID webhookIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;
    WebhookList getWebhooks() throws UnspecifiedShopInformation, BadRequestException, IOException;


    static Yookassa initialize(int shopIdentifier, @NonNull String shopToken) {
        return new RealYookassa(shopIdentifier, shopToken);
    }
}
