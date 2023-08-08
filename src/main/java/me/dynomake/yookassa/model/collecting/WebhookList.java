package me.dynomake.yookassa.model.collecting;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Webhook;

import java.util.Collection;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class WebhookList {
    String type;
    Collection<Webhook> items;
    UUID next_cursor;
}
