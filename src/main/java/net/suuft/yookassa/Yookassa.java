package net.suuft.yookassa;

import lombok.NonNull;
import net.suuft.yookassa.event.YookassaEvent;
import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.model.Amount;
import net.suuft.yookassa.model.Payment;
import net.suuft.yookassa.model.Refund;
import net.suuft.yookassa.model.Webhook;
import net.suuft.yookassa.model.collecting.PaymentList;
import net.suuft.yookassa.model.collecting.RefundList;
import net.suuft.yookassa.model.collecting.WebhookList;

import java.io.IOException;
import java.util.UUID;

public interface Yookassa {

    Payment createPayment(@NonNull Amount amount, @NonNull String description, @NonNull String redirectUrl) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Payment getPayment(@NonNull UUID paymentIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    // todo: limit, filters (status, date, paidDate..)
    PaymentList getPayments() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund createRefund(@NonNull UUID paymentIdentifier, @NonNull Amount amount) throws UnspecifiedShopInformation, BadRequestException, IOException;

    Refund getRefund(@NonNull UUID refundIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;

    RefundList getRefunds() throws UnspecifiedShopInformation, BadRequestException, IOException;

    Webhook createWebhook(@NonNull YookassaEvent event, @NonNull String url) throws UnspecifiedShopInformation, BadRequestException, IOException;
    void deleteWebhook(@NonNull UUID webhookIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException;
    WebhookList getWebhooks() throws UnspecifiedShopInformation, BadRequestException, IOException;

}
