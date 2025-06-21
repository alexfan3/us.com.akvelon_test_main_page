package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class FooterMenu {

    public FooterMenu selectNamePagesInSiteNavigator(String namePages) {
        $("#footer-menu").scrollTo();
        $("#footer-menu").$$("ul li").findBy(text(namePages)).click();
        return this;
    }

    public FooterMenu assertToOpenPage(String pageUrl) {
        webdriver().shouldHave(urlContaining(pageUrl));
        return this;
    }

    public FooterMenu selectButtonFromSectionCareers(String namePages) {
        $("#footer-menu").scrollTo();
        $("#footer-menu").$$("ul li").findBy(text("Careers")).hover();
        $("#footer-menu").$("ul.sub-menu").$$("li").findBy(text(namePages)).hover();
        sleep(500);
        $("#footer-menu").$("ul.sub-menu").$$("li").findBy(text(namePages)).click();
        return this;
    }


}
