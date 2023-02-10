package net.suuft.yookassa;

import net.suuft.yookassa.type.Payment;

import java.math.BigDecimal;

import static net.suuft.yookassa.YookassaJavaSdk.*;

public class SmallTest {

    public static void main(String[] args) {
        setShopId(1);
        setShopToken("h");


        try {
            Payment payment = createPayment(BigDecimal.valueOf(169.99), "Test Payment");
            System.out.println("link: " + payment.confirmation.confirmation_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
