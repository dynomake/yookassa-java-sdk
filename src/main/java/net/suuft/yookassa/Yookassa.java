package net.suuft.yookassa;

import lombok.NonNull;
import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.type.Amount;
import net.suuft.yookassa.type.Payment;
import net.suuft.yookassa.type.Refund;
import net.suuft.yookassa.type.collecting.PaymentList;
import net.suuft.yookassa.type.collecting.RefundList;

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

}
