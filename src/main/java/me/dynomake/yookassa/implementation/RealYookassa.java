package me.dynomake.yookassa.implementation;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.dynomake.yookassa.Yookassa;
import me.dynomake.yookassa.exception.BadRequestException;
import me.dynomake.yookassa.utility.JsonUtil;
import me.dynomake.yookassa.exception.UnspecifiedShopInformation;
import me.dynomake.yookassa.model.Payment;
import me.dynomake.yookassa.model.Refund;
import me.dynomake.yookassa.model.collecting.PaymentList;
import me.dynomake.yookassa.model.collecting.RefundList;
import me.dynomake.yookassa.model.request.PaymentRequest;
import me.dynomake.yookassa.model.request.RefundRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;
import java.util.Base64;

@AllArgsConstructor
public class RealYookassa implements Yookassa {

    private int shopIdentifier;
    private String shopToken;

    @Override
    public Payment createPayment(@NonNull PaymentRequest paymentRequest) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(Payment.class, "https://api.yookassa.ru/v3/payments", "POST", JsonUtil.toJson(paymentRequest));
    }

    @Override
    public Payment getPayment(@NonNull UUID paymentIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(Payment.class, "https://api.yookassa.ru/v3/payments/" + paymentIdentifier, "GET", null);
    }

    @Override
    public PaymentList getPayments() throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(PaymentList.class, "https://api.yookassa.ru/v3/payments", "GET", null);
    }

    @Override
    public Refund createRefund(@NonNull RefundRequest request) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(Refund.class, "https://api.yookassa.ru/v3/refunds", "POST", JsonUtil.toJson(request));
    }

    @Override
    public Refund getRefund(@NonNull UUID refundIdentifier) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(Refund.class, "https://api.yookassa.ru/v3/refunds/" + refundIdentifier, "GET", null);
    }

    @Override
    public RefundList getRefunds() throws UnspecifiedShopInformation, BadRequestException, IOException {
        return parseResponse(RefundList.class, "https://api.yookassa.ru/v3/refunds", "GET", null);
    }

    private <T> T parseResponse(Class<T> wannableClass, @NonNull String requestAddress, @NonNull String requestMethod, String writableJson) throws IOException, UnspecifiedShopInformation, BadRequestException {
//        System.out.println("Request: " + writableJson);
        if (shopIdentifier == 0 || shopToken == null) {
            throw new UnspecifiedShopInformation();
        }
        URL url = new URL(requestAddress);

        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        httpConn.setRequestMethod(requestMethod);

        String auth = shopIdentifier + ":" + shopToken;
        String basicAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

        if (writableJson != null) {
            httpConn.setRequestProperty("Idempotence-Key", UUID.randomUUID().toString());
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());

            writer.write(writableJson);
            writer.flush();
            writer.close();
            httpConn.getOutputStream().close();
        }

        boolean success = httpConn.getResponseCode() / 100 == 2;
        InputStream responseStream = success
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");

        String response = s.hasNext() ? s.next() : "";

//        System.out.println(response);

        if (!success) {
//            System.out.println(response);
            throw new BadRequestException();
        }

        if (wannableClass == null) return null;

        return JsonUtil.fromJson(response, wannableClass);
    }
}
