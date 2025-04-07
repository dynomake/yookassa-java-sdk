package me.dynomake.yookassa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("paid")
    private boolean paid;

    @JsonProperty("amount")
    private Amount amount;

    @JsonProperty("authorization_details")
    private AuthorizationDetails authorizationDetails;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("captured_at")
    private OffsetDateTime capturedAt;

    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty("description")
    private String description;
    @JsonProperty("receipt_registration")
    private String receiptRegistration;
    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    private Recipient recipient;
    private boolean refundable;
    private Confirmation confirmation;
    private boolean test;

    @JsonProperty("income_amount")
    private Amount incomeAmount;
    @JsonProperty("refunded_amount")
    private Amount refundedAmount;
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthorizationDetails {
        @JsonProperty("rrn")
        private String rrn;

        @JsonProperty("auth_code")
        private String authCode;

        @JsonProperty("three_d_secure")
        private ThreeDSecure threeDSecure;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ThreeDSecure {
        @JsonProperty("applied")
        private boolean applied;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PaymentMethod {
        @JsonProperty("type")
        private String type;

        @JsonProperty("id")
        private UUID id;

        @JsonProperty("saved")
        private boolean saved;

        @JsonProperty("status")
        private String status;  // Добавляем это поле

        @JsonProperty("card")
        private Card card;

        @JsonProperty("title")
        private String title;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Card {
        @JsonProperty("first6")
        private String first6;

        @JsonProperty("last4")
        private String last4;

        @JsonProperty("expiry_month")
        private String expiryMonth;

        @JsonProperty("expiry_year")
        private String expiryYear;

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("card_product")
        private CardProduct cardProduct;

        @JsonProperty("issuer_country")
        private String issuerCountry;

        @JsonProperty("issuer_name")
        private String issuerName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CardProduct {
        @JsonProperty("code")
        private String code;

        @JsonProperty("name")
        private String name;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Recipient {
        @JsonProperty("account_id")
        private String accountId;

        @JsonProperty("gateway_id")
        private String gatewayId;
    }
}
