package me.dynomake.yookassa.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Amount;

import java.util.UUID;

@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class RefundRequest {

    @JsonProperty("amount")
    private Amount amount;
    
    @JsonProperty("payment_id")
    private UUID paymentId;
}
