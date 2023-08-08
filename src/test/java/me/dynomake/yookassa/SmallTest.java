package me.dynomake.yookassa;

import me.dynomake.yookassa.exception.BadRequestException;
import me.dynomake.yookassa.exception.UnspecifiedShopInformation;
import me.dynomake.yookassa.model.Amount;
import me.dynomake.yookassa.model.Payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SmallTest {

    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) throws UnspecifiedShopInformation, BadRequestException, IOException {
        Yookassa yookassa = Yookassa.initialize(1, "");

        // запросим платеж с банковской карты и сохраним её)))
        Payment payment = yookassa.createPayment("bank_card", true,
                new Amount(BigDecimal.valueOf(1), "EUR"), "Test Payment", "https://suuft.naifu.works");

        // только если покупатель разрешил сохранить метод оплаты
        if (payment.payment_method.saved) {
            UUID methodId = payment.payment_method.id;

            yookassa.createRecurrentPayment(methodId,
                    new Amount(BigDecimal.valueOf(1), "EUR"), "ты сохранил карту и потерял евро");
        }

        System.out.println("bill link:" + payment.confirmation.confirmation_url);

        System.out.println(yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "RUB"), "test", "https://suuft.naifu.works").confirmation.confirmation_url);
    }
}
