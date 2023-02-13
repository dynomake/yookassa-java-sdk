package net.suuft.yookassa.type.collecting;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import net.suuft.yookassa.type.Payment;

import java.util.Collection;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class PaymentList {
    String type;
    Collection<Payment> items;
    UUID next_cursor;
}
