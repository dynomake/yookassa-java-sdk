package space.yakonay.yookassa;

import lombok.Setter;
import lombok.experimental.UtilityClass;
import space.yakonay.yookassa.exception.BadRequestException;
import space.yakonay.yookassa.exception.UnspecifiedShopInformation;
import space.yakonay.yookassa.type.Payment;
import space.yakonay.yookassa.type.PaymentRequest;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;

@UtilityClass
public class YookassaJavaSdk {
    public URL PAYMENT_API_URL;
    @Setter
    private int shopId = 0;
    @Setter
    private String shopToken;

    static {
        try {
            PAYMENT_API_URL = new URL("https://api.yookassa.ru/v3/payments");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Payment createPayment(BigDecimal value, String currency, String description, String redirectUrl) throws UnspecifiedShopInformation, BadRequestException, IOException {
        if (shopId == 0 || shopToken == null) {
            throw new UnspecifiedShopInformation();
        }

        HttpURLConnection httpConn = (HttpURLConnection) PAYMENT_API_URL.openConnection();

        httpConn.setRequestMethod("POST");

        byte[] message = (shopId + ":" + shopToken)
                .getBytes(StandardCharsets.UTF_8);
        String basicAuth = DatatypeConverter.printBase64Binary(message);

        httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);
        httpConn.setRequestProperty("Idempotence-Key", UUID.randomUUID().toString());
        httpConn.setRequestProperty("Content-Type", "application/json");
        httpConn.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());

        writer.write(PaymentRequest.create(value, currency, redirectUrl, description).toJson());
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        boolean success = httpConn.getResponseCode() / 100 == 2;
        InputStream responseStream = success
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");

        String response = s.hasNext() ? s.next() : "";

        if (!success) {
            System.out.println(response);
            throw new BadRequestException();
        }
        return Payment.fromJson(response);
    }

    public Payment createPayment(BigDecimal value, String description, String redirectUrl) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return createPayment(value, "RUB", description, redirectUrl);
    }

    public Payment createPayment(BigDecimal value, String description) throws UnspecifiedShopInformation, BadRequestException, IOException {
        return createPayment(value, description, "https://yakonay.space/404");
    }
}
