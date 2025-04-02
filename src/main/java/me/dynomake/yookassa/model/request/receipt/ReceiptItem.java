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
public class ReceiptItem {
    private String description;
    private Amount amount;
    @JsonProperty("vat_code")
    private int vat;
    private int quantity;
    private String measure;
    @JsonProperty("payment_subject")
    private String subject;
    @JsonProperty("payment_mode")
    private String paymentMode;
    @JsonProperty("country_of_origin_code")
    private String originCountry;
    @JsonProperty("customs_declaration_number")
    private String declarationNumber;
    private String excise;
    @JsonProperty("mark_quantity")
    private String markQuantity;
    @JsonProperty("product_code")
    private String productCode;
    @JsonProperty("mark_code_info")
    private Object markCodeInfo;
    @JsonProperty("mark_mode")
    private String markMode;
    @JsonProperty("payment_subject_industry_details")
    private Object paymentSubjectIndustryDetails;

}
