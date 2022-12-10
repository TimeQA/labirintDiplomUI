package labirint.tests;

import io.qameta.allure.Owner;
import labirint.pages.BasketPage;
import labirint.pages.MainPage;
import labirint.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Owner("Dmitrii")

public class AddBasketTest extends TestBase {

    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();
    SearchPage searchPage = new SearchPage();


    @Tag("addBasket")
    @DisplayName("Проверка добавления книги в корзину")
    @ValueSource(strings = {"Огненный поток", "1984"})
    @ParameterizedTest(name = "Проверка добавления книги в корзину {0}")
    void checkAddBookBasketPO(String bookName) {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step(String.format("Поиск книги %s", bookName), () -> {
            searchPage.searchBook(bookName);
        });

        step(String.format("Поиск книги %s", bookName), () -> {
            basketPage.clickButtonAddedProductBasket();
        });


        step("Переходим в корзину", () -> {
            basketPage.goBasketPage();
        });

        step(String.format("Проверка наличия книги в разделе  %s \"Отложено\"" , bookName), () -> {
            basketPage.checkProductOnBasketOrFavoritesPage(bookName);
        });
    }

}
