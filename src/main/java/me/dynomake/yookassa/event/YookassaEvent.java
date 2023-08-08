package me.dynomake.yookassa.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum YookassaEvent {

    PAYMENT_WAITING_FOR_CAPTURE("payment.waiting_for_capture"),
    PAYMENT_SUCCESS_PAID("payment.succeeded"),
    PAYMENT_CANCELED("payment.canceled"),

    REFUND_SUCCESS("refund.succeeded"),

    ;

    String eventName;
}
