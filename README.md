# | `yookassa-java-sdk`
Данное маленькое SDK постоянно улучшаеться и изменяеться разработчиком suuft. Содержит внутри себя не самый лучший код написанный мной несколько месяцев назад. Если вы хотите помочь с рефакторингом - делайте пулл реквесты.

---
## `Использование:`
Чтобы начать использовать эту библиотеку, нужно её добавить в свой проект.

### `Инициализация:`
Инициализация небходимых значений, если их не инициализировать, будет вызвано исключение UnspecifiedShopInformation:
```java
YookassaJavaSdk.setShopId(YOU_SHOP_ID);
YookassaJavaSdk.setShopToken(YOU_SHOP_TOKEN);
```

### `Обьект платежа:`
Вы можете легко создать платеж, покажу на примере с инициализацией переменной payment:
```java
Payment payment = YookassaJavaSdk.createPayment(BigDecimal.valueOf(PAYMENT_COST),
                    "payment description", URL_TO_REDIRECT_AFTER_PAY);
```
В обьекте платежа есть абсолютно все значения, как и в обычном Restful-API yookassa.

---
## `Добавление в зависимости:`
### | `Gradle`:
Пример добавления этой зависимости в проект с хорошим инструментом автоматической сборки:
```groovy
repositories {
    // other repositories
    maven {
        name = "clojars.org"
        url = uri("https://repo.clojars.org")
    }
}

dependencies {
    // other depend
    implementation 'works.naifu:yookassa-java-sdk:0.0.1-SNAPSHOT'
}
```

### | `Maven`:

И с менее хорошим:

```xml
<repository>
    <id>clojars.org</id>
    <url>https://repo.clojars.org</url>
</repository>
```

и конечно зависимость:

```xml

<dependency>
    <groupId>works.naifu</groupId>
    <artifactId>yookassa-java-sdk</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
