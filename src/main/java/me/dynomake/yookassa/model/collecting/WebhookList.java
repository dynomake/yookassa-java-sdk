package me.dynomake.yookassa.model.collecting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import me.dynomake.yookassa.model.Webhook;

import java.util.Collection;
import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class WebhookList {
    private String type;
    private Collection<Webhook> items;
    @JsonProperty("next_cursor")
    private UUID next;
}
