package me.dynomake.yookassa.model.collecting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Payment;

import java.util.Collection;
import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PaymentList {
    private String type;
    private Collection<Payment> items;
    @JsonProperty("next_cursor")
    private UUID next;
}
