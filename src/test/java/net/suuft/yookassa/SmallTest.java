package net.suuft.yookassa;

import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.type.Amount;
import net.suuft.yookassa.type.Payment;
import net.suuft.yookassa.utility.JsonUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SmallTest {

    private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) throws UnspecifiedShopInformation, BadRequestException, IOException {
        Yookassa yookassa = YookassaInitializer
                .initializeSdk(1, "");

        Payment payment = yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "EUR"), "Test Payment", "https://suuft.naifu.works");
        System.out.println("bill link:" + payment.confirmation.confirmation_url);

        System.out.println(yookassa.createPayment(new Amount(BigDecimal.valueOf(1), "RUB"), "test", "https://suuft.naifu.works").confirmation.confirmation_url);
    }

    private static void schedule(long delay, TimeUnit timeUnit, Runnable command) {
        scheduledExecutor.schedule(command, delay, timeUnit);
    }
}
