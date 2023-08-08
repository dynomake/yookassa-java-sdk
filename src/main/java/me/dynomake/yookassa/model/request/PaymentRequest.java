package me.dynomake.yookassa.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Payment;

import java.util.UUID;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class PaymentRequest {

    Amount amount;
    ConfirmationType confirmation;
    boolean capture;
    String description;
    PaymentMethodData payment_method_data;
    boolean save_payment_method;
    UUID payment_method_id;

    public static PaymentRequest create(Amount amount, String urlRedirect, String description) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, null, false, null);
    }

    public static PaymentRequest create(Amount amount, String urlRedirect, String description, String paymentMethod, boolean save) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description, new PaymentMethodData(paymentMethod), save, null);
    }

    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
    private static class PaymentMethodData {
        String type;
    }

    @FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
    private static class ConfirmationType {
        String type = "redirect";
        String return_url;

        public ConfirmationType(String url) {
            this.return_url = url;
        }
    }
}
