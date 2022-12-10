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

public class AddFavoritesTest extends TestBase {

    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();
    SearchPage searchPage = new SearchPage();


    @Tag("addFavorites")
    @DisplayName("Проверка добавления книги в раздел \"Отложено\"")
    @ValueSource(strings = {"Огненный поток", "1984"})
    @ParameterizedTest(name = "Проверка добавления книги в раздел \"Отложено\" {0}")
    void addBookBasketAndFavouritesPO(String bookName) {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step(String.format("Поиск книги %s", bookName), () -> {
            searchPage.searchBook(bookName);
        });

        step("Нажать на кнопку \"Отложить\"", () -> {
            basketPage.addFirstProductInFavorites();
        });

        step("Переход на страницу \"Отложено\"", () -> {
            basketPage.goFavoritesPage();
        });

        step(String.format("Проверка наличия книги в разделе  %s \"Отложено\"" , bookName), () -> {
            basketPage.checkProductOnBasketOrFavoritesPage(bookName);
        });
    }

}
