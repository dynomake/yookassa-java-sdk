package me.dynomake.yookassa.model.request.receipt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    private ReceiptCustomer customer;
    private List<ReceiptItem> items;
    private String email;
    private String phone;
    @JsonProperty("tax_system_code")
    private String taxSystemCode;
}
