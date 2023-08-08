package me.dynomake.yookassa.model.request;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Amount;

import java.util.UUID;

/**
 * {
 *         "amount": {
 *           "value": "2.00",
 *           "currency": "RUB"
 *         },
 *         "capture": true,
 *         "payment_method_id": "<Идентификатор сохраненного способа оплаты>",
 *         "description": "Заказ №105"
 *       }
 */
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class RecurrentPaymentRequest {
    Amount amount;
    boolean capture;
    UUID payment_method_id;
    String description;
}
