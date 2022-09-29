<div id="header" align="center">
<h1>yookassa-java-sdk</h1>

---

  <div id="badges">

<a href="LICENSE">
        <img src="https://img.shields.io/apm/l/vim-mode?label=LICENSE&style=for-the-badge"/>
</a>
<a href="https://github.com/swiftysweet/yookassa-java-sdk/releases/tag/default">
        <img src="https://img.shields.io/amo/dw/dustman?color=dd&label=Download&style=for-the-badge"/>
</a>
    <a href="https://vk.com/swiftyclown">
      <img src="https://img.shields.io/badge/VKontakte-blue?style=for-the-badge&logo=vk&logoColor=white" alt="VKontakte"/>
    </a>
    <a href="https://www.youtube.com/channel/UCVjp9ytLEhO4vZmDGjtR2tg">
      <img src="https://img.shields.io/badge/YouTube-red?style=for-the-badge&logo=youtube&logoColor=white" alt="Youtube"/>
    </a>
    <a href="https://discord.gg/SWZ2cPGnBT">
      <img src="https://img.shields.io/badge/Discord-brown?style=for-the-badge&logo=discord&logoColor=white" alt="Discord"/>
    </a>
      <a href="https://t.me/swiftyclown">
      <img src="https://img.shields.io/badge/Telegram-blue?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram"/>
    </a>
  </div>
</div>

## 🖤 `Об SDK:`
Данное маленькое SDK постоянно улучшаеться и изменяеться разработчиком swiftysweet. Содержит внутри себя не самый лучший код написанный мной несколько месяцев назад. Если вы хотите помочь с рефакторингом - делайте пулл реквесты.
## :exclamation: `Использование:`
Чтобы начать использовать эту библиотеку, нужно её добавить в свой проект.
### `Инициализация:`
Инициализация небходимых значений, если их не инициализировать, будет UnspecifiedShopInformation:
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


