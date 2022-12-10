package labirint.pages;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final ElementsCollection elementsOnPage = $$("div .genres-carousel__item");

    private final SelenideElement headerMenu = $(".b-header-b-menu-wrapper");

    private final ElementsCollection itemDropDownMenu = $$("ul li.b-menu-second-item");

    private final SelenideElement formaliseOrBasketButtonSomeProduct = $(".product-buy-margin:nth-child(1)");


    public final MainPage openPage() {

        open("");

        return this;
    }

    public final MainPage healthCheck() {
        elementsOnPage.shouldBe(CollectionCondition.sizeGreaterThan(0));

        return this;
    }

    public final MainPage selectItemHeaderMenu(String typeDevice) {
        headerMenu.$(byText(typeDevice)).hover();

        return this;
    }

    public final MainPage checkSubitemDropDownMenu(List<String> expectedTypeDevice) {
        itemDropDownMenu.contains(expectedTypeDevice);

        return this;
    }


    public final MainPage clickButtonAddBasket() {
        formaliseOrBasketButtonSomeProduct.$(byText("В КОРЗИНУ")).click();
        return this;
    }


    public final MainPage clickButtonFormaliseOrder() {
        formaliseOrBasketButtonSomeProduct.shouldBe(Condition.text("ОФОРМИТЬ")).click();

        return this;
    }


}