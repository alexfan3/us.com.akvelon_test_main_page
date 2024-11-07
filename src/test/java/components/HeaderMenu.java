package components;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


public class HeaderMenu {
    public HeaderMenu selectNamePagesInSiteNavigator(String namePages) {
        $("#site-navigation").$$("ul li").findBy(text(namePages)).click();
        return this;
    }

    public HeaderMenu assertToOpenPage(String pageUrl) {
        webdriver().shouldHave(urlContaining(pageUrl));
        return this;
    }

    public HeaderMenu selectButtonFromSectionCareers(String namePages) {
        $("#site-navigation").$$("ul li").findBy(text("Careers")).hover();
        $("ul.sub-menu").$$("li").findBy(text(namePages)).click();
        return this;
    }

    public HeaderMenu clickForButtonSendCV() {
        $(".akv-container").$(".site-header__cta .btn").click();
        return this;
    }


}
