package me.dynomake.yookassa.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class WebhookRequest {
    String event;
    String url;
}
