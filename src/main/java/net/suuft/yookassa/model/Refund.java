package net.suuft.yookassa.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

/*
{
  "id": "216749f7-0016-50be-b000-078d43a63ae4",
  "status": "succeeded",
  "amount": {
    "value": "1",
    "currency": "RUB"
  },
  "created_at": "2017-10-04T19:27:51.407Z",
  "payment_id": "216749da-000f-50be-b000-096747fad91e"
}
 */

@FieldDefaults(level = AccessLevel.PUBLIC)
public class Refund {

    UUID id;
    String status;
    Amount amount;
    String created_at;
    UUID payment_id;

}
