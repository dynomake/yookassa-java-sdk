package me.dynomake.yookassa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Confirmation {
    private String type = "redirect";
    private String locale = null;
    @JsonProperty("return_url")
    private String returnUrl;
    @JsonProperty("confirmation_url")
    private String confirmationUrl;

}