package me.dynomake.yookassa.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Webhook {
    private UUID id;
    private String event;
    private String url;
}
