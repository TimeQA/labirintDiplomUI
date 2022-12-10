package labirint.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {


    private final SelenideElement basketLink = $(".cart-icon-js");

    private final SelenideElement favoritesLink = $(".b-header-b-personal-e-icon-count-m-putorder");

    private final SelenideElement firstProductInFavorites = $(".icon-fave:nth-child(1)");

    private final SelenideElement selectedProductInBasketOrFavorites = $(".need-watch");


    public final BasketPage goFavoritesPage() {
        favoritesLink.click();

        return this;
    }

    public final BasketPage goBasketPage() {
        basketLink.click();

        return this;
    }

    public final BasketPage addFirstProductInFavorites() {
        firstProductInFavorites.click();

        return this;
    }

    public final BasketPage checkProductOnBasketOrFavoritesPage(String bookName) {
        selectedProductInBasketOrFavorites.shouldBe(Condition.text(bookName));

        return this;
    }

    public final BasketPage clickButtonAddedProductBasket() {
        selectedProductInBasketOrFavorites.$(byText("В КОРЗИНУ")).click();
        return this;
    }
}