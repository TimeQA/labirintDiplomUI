package labirint.tests;

import io.qameta.allure.Owner;
import labirint.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;

@Owner("Dmitrii")

public class HealthCheckTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Tag("mainPage")
    @Test
    @DisplayName("Проверка главной страницы и наличие на ней элементов")
    void mainPageNotEmptyPO() {

        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });

        step("Проверка наличия элементов товаров на главной страцице", () -> {
            mainPage.healthCheck();
        });
    }
}
