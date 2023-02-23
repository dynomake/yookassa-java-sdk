package net.suuft.yookassa.model.collecting;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import net.suuft.yookassa.model.Refund;

import java.util.Collection;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class RefundList {
    String type;
    Collection<Refund> items;
    UUID next_cursor;
}
