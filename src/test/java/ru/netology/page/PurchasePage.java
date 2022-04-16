package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PurchasePage {
    //Кнопка "Купить" и заголовок "Оплата по карте":
    private final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement buyHeading = $(byText("Оплата по карте"));
    //Кнопка "Купить в кредит" и заголовок "Кредит по данным карты":
    private final SelenideElement creditButton = $(byText("Купить в кредит"));
    private final SelenideElement creditHeading = $(byText("Кредит по данным карты"));
    //Форма для ввода данных, со всеми полями ввода, ошибками полей и кнопкой "Продолжить":
    private final SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement cardNumberFieldError = $x("//*[text()='Номер карты']/..//*[@class='input__sub']");
    private final SelenideElement monthField = $("input[placeholder='08']");
    private final SelenideElement monthFieldError = $x("//*[text()='Месяц']/..//*[@class='input__sub']");
    private final SelenideElement yearField = $("input[placeholder='22']");
    private final SelenideElement yearFieldError = $x("//*[text()='Год']/..//*[@class='input__sub']");
    private final SelenideElement ownerField = $(byText("Владелец")).parent().$("input");
    private final SelenideElement ownerFieldError = $x("//*[text()='Владелец']/..//*[@class='input__sub']");
    private final SelenideElement cvcField = $("input[placeholder='999']");
    private final SelenideElement cvcFieldError = $x("//*[text()='CVC/CVV']/..//*[@class='input__sub']");
    private final SelenideElement notificationSuccessfully = $(".notification_status_ok");
    private final SelenideElement notificationError = $(".notification_status_error");
    private final SelenideElement continueButton = $("form button");

    public void cardPayment() {
        buyButton.click();
        buyHeading.shouldBe(Condition.visible);
    }

    public void cardCredit() {
        creditButton.click();
        creditHeading.shouldBe(Condition.visible);
    }

    public void emptyForm() {
        continueButton.click();
        cardNumberFieldError.shouldBe(Condition.visible);
        monthFieldError.shouldBe(Condition.visible);
        yearFieldError.shouldBe(Condition.visible);
        ownerFieldError.shouldBe(Condition.visible);
        cvcFieldError.shouldBe(Condition.visible);
    }

    private void cardNumberFieldErrorHidden() {
        monthFieldError.shouldBe(Condition.hidden);
        yearFieldError.shouldBe(Condition.hidden);
        ownerFieldError.shouldBe(Condition.hidden);
        cvcFieldError.shouldBe(Condition.hidden);
    }

    public void emptyCardNumberField(DataGenerator.CardInfo info) {
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        cardNumberFieldError.shouldBe(Condition.visible);
        cardNumberFieldErrorHidden();
    }

    private void monthFieldErrorHidden() {
        cardNumberFieldError.shouldBe(Condition.hidden);
        yearFieldError.shouldBe(Condition.hidden);
        ownerFieldError.shouldBe(Condition.hidden);
        cvcFieldError.shouldBe(Condition.hidden);
    }

    public void emptyMonthField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        monthFieldError.shouldBe(Condition.visible);
        monthFieldErrorHidden();
    }

    private void yearFieldErrorHidden() {
        cardNumberFieldError.shouldBe(Condition.hidden);
        monthFieldError.shouldBe(Condition.hidden);
        ownerFieldError.shouldBe(Condition.hidden);
        cvcFieldError.shouldBe(Condition.hidden);
    }

    public void emptyYearField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        yearFieldError.shouldBe(Condition.visible);
        yearFieldErrorHidden();
    }

    private void ownerFieldErrorHidden() {
        cardNumberFieldError.shouldBe(Condition.hidden);
        monthFieldError.shouldBe(Condition.hidden);
        yearFieldError.shouldBe(Condition.hidden);
        cvcFieldError.shouldBe(Condition.hidden);
    }

    public void emptyOwnerField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        ownerFieldError.shouldBe(Condition.visible);
        ownerFieldErrorHidden();
    }

    private void cvcFieldErrorHidden() {
        cardNumberFieldError.shouldBe(Condition.hidden);
        monthFieldError.shouldBe(Condition.hidden);
        yearFieldError.shouldBe(Condition.hidden);
        ownerFieldError.shouldBe(Condition.hidden);
    }

    public void emptyCVCField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        continueButton.click();
        cvcFieldError.shouldBe(Condition.visible);
        cvcFieldErrorHidden();
    }

    public void invalidCardNumberField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        cardNumberFieldError.shouldBe(Condition.visible);
        cardNumberFieldErrorHidden();
    }

    public void invalidMonthField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        monthFieldError.shouldBe(Condition.visible);
        monthFieldErrorHidden();
    }

    public void invalidYearField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        yearFieldError.shouldBe(Condition.visible);
        yearFieldErrorHidden();
    }

    public void invalidOwnerField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        ownerFieldError.shouldBe(Condition.visible);
        ownerFieldErrorHidden();
    }

    public void invalidCVCField(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        cvcFieldError.shouldBe(Condition.visible);
        cvcFieldErrorHidden();
    }

    public void sendingData(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getNumberCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvcField.setValue(info.getCvc());
        continueButton.click();
    }

    public void bankApproved() {
        notificationSuccessfully.shouldBe(Condition.visible);
    }

    public void bankDeclined() {
        notificationError.shouldBe(Condition.visible);
    }
}
