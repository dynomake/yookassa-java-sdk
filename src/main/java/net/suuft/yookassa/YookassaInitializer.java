package net.suuft.yookassa;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.suuft.yookassa.implementation.RealYookassa;

@UtilityClass
public class YookassaInitializer {

    public Yookassa initializeSdk(int shopIdentifier, @NonNull String shopToken) {
        return new RealYookassa(shopIdentifier, shopToken);
    }
}
