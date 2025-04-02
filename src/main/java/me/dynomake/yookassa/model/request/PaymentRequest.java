package me.dynomake.yookassa.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Confirmation;
import me.dynomake.yookassa.model.PaymentMethodData;
import me.dynomake.yookassa.model.request.receipt.Receipt;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
public class PaymentRequest {
    
    private Amount amount;
    private Confirmation confirmation;
    
    @Builder.Default
    private boolean capture = true;
    
    private String description;
    
    @JsonProperty("payment_method_data")
    private PaymentMethodData paymentMethodData;
    
    @JsonProperty("save_payment_method")
    @Builder.Default
    private boolean savePaymentMethod = false;
    
    @JsonProperty("payment_method_id")
    private UUID paymentMethodId;
    
    @JsonProperty("payment_token")
    private String paymentToken;
    
    @JsonProperty("payment_method_type")
    private String paymentMethodType;
    
    @JsonProperty("client_ip")
    private String clientIp;

    private Receipt receipt;
    private Map<String, Object> metadata;
    
    @JsonProperty("merchant_customer_id")
    private String merchantCustomerId;
}
