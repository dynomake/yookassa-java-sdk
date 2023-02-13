package net.suuft.yookassa.type;

import com.google.gson.JsonElement;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.UUID;

/*
{
  "id": "23d93cac-000f-5000-8000-126628f15141",
  "status": "pending",
  "paid": false,
  "amount": {
    "value": "100.00",
    "currency": "RUB"
  },
  "confirmation": {
    "type": "redirect",
    "confirmation_url": "https://yoomoney.ru/api-pages/v2/payment-confirm/epl?orderId=23d93cac-000f-5000-8000-126628f15141"
  },
  "created_at": "2019-01-22T14:30:45.129Z",
  "description": "Заказ №1",
  "metadata": {},
  "recipient": {
    "account_id": "100500",
    "gateway_id": "100700"
  },
  "refundable": false,
  "test": false
}
 */

@FieldDefaults(level = AccessLevel.PUBLIC)
public class Payment {
    UUID id;
    String status;
    boolean paid;
    Amount amount;
    ConfirmationType confirmation;
    String created_at;
    String description;
    JsonElement metadata;
    RecipientType recipient;
    boolean refundable;
    boolean test;
    String redirectUrl;

    @FieldDefaults(level = AccessLevel.PUBLIC)
    private static class RecipientType {
        String account_id;
        String gateway_id;
    }

    @FieldDefaults(level = AccessLevel.PUBLIC)
    public static class ConfirmationType {
        String type = "redirect";
        String confirmation_url;

    }
//
//    public Payment update() throws UnspecifiedShopInformation, BadRequestException, IOException {
//        return YookassaJavaSdk.createPayment(amount.value, amount.currency, description, redirectUrl, idempotenceKey);
//    }

}
