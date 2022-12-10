package labirint.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement searchField = $("#search-field");

    public final SearchPage searchBook(final String bookName) {
        searchField.setValue(bookName).pressEnter();

        return this;
    }

}