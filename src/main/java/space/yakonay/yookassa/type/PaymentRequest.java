package space.yakonay.yookassa.type;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import space.yakonay.yookassa.utility.JsonUtil;

import java.math.BigDecimal;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class PaymentRequest {

    AmountType amount;
    ConfirmationType confirmation;
    boolean capture;
    String description;

    public static PaymentRequest create(BigDecimal value, String urlRedirect, String description) {
        return new PaymentRequest(new AmountType(value), new ConfirmationType(urlRedirect),true, description);
    }

    public String toJson() {
        return JsonUtil.toJson(this);
    }

    @FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
    public static class AmountType {
        BigDecimal value;
        String currency = "RUB";

        public AmountType(BigDecimal value) {
            this.value = value;
        }
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
