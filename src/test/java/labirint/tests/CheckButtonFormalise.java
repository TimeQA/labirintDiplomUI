package labirint.tests;

import io.qameta.allure.Owner;
import labirint.pages.BasketPage;
import labirint.pages.MainPage;
import labirint.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Owner("Dmitrii")

public class CheckButtonFormalise extends TestBase {

    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();
    SearchPage searchPage = new SearchPage();
    

    @Tag("formalise")
    @Test
    @DisplayName("Появление кнопки \"ОФОРМИТЬ\"")
    void appearanceButtonForOrderPO() {

        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Добавление товара в корзину", () -> {
            mainPage.clickButtonAddBasket();
        });

        step("Переход на страницу оформления товара по кнопке \"ОФОРМИТЬ\"", () -> {
            mainPage.clickButtonFormaliseOrder();
        });
    }
}
