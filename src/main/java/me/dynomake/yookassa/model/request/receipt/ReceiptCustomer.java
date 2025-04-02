package me.dynomake.yookassa.model.request.receipt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.dynomake.yookassa.model.Amount;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptCustomer {
    private String email;
    private String phone;
    @JsonProperty("full_name")
    private String fullName;
    private String inn;
}
