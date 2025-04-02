package me.dynomake.yookassa.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WebhookRequest {
    @JsonProperty("event")
    private String event;
    
    @JsonProperty("url")
    private String url;
}