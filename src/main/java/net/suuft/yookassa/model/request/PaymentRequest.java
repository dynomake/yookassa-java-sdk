package net.suuft.yookassa.model.request;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.suuft.yookassa.model.Amount;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class PaymentRequest {

    Amount amount;
    ConfirmationType confirmation;
    boolean capture;
    String description;

    public static PaymentRequest create(Amount amount, String urlRedirect, String description) {
        return new PaymentRequest(amount, new ConfirmationType(urlRedirect), true, description);
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
