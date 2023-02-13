package net.suuft.yookassa.type;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class Amount {
    BigDecimal value;
    String currency;

    public Amount(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }
}