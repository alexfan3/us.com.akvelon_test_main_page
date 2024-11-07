package pages.home;



import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class BodyLinks {

    public BodyLinks clickForSubscribeForm() {
        $("#modal-cta").sibling(0).click();
        return this;
    }

    public BodyLinks assertToOpenSubscribeForm() {

        $("#modal-subscribe").$(".modal-header .modal-title").shouldHave(text("Subscribe our vacancies"));
        $("#modal-subscribe .modal-wrapper").$(".modal-button.modal-close").click();
        return this;
    }

    public BodyLinks clickForDonateButton() {

        $(".site-header__banner").$(".site-header__banner-content .btn").click();
        return this;
    }

    public BodyLinks assertToOpenPageInNewWindow(String url) {
        switchTo().window(1);
        webdriver().shouldHave(urlContaining(url));
        closeWindow();
        switchTo().window(0);
        return this;
    }

    public BodyLinks clickForButtonSeeVacancies() {

        $("#content .akv-container").$(".hero-home__btns .btn").click();
        return this;
    }

    public BodyLinks asserToOpenPageInThisWindow(String url) {
        webdriver().shouldHave(urlContaining(url));
        return this;
    }

    public BodyLinks clickForButtonOurProjects() {
        $("#content .section-our-projects").$(".section-wrapper").scrollTo();
        $("#content .section-our-projects").$(".section-wrapper .section-footer").$(".btn").click();
        return this;
    }

    public BodyLinks clickForButtonLearnMoreSectionCareers() {
        $("#content .section-careers").$(".section-wrapper").scrollTo();
        $("#content .section-careers").$(".section-wrapper .careers__content").$(".btn").click();
        return this;
    }

    public BodyLinks clickForButtonInternshipSectionCareers(String namePages) {
        $("#content .section-careers").$(".section-wrapper").scrollTo();
        $("#content .section-careers").$(".section-wrapper .careers__cards-wrapper")
                .$("a[href='" + namePages + "']").click();
        return this;
    }

    public BodyLinks clickForSubscribeVacanciesButton() {
        $("#content .section-call-to-action").$(".section-wrapper").scrollTo();
        $("#content .section-call-to-action").$(".section-wrapper .btn").click();

        return this;
    }

    public BodyLinks clickForButtonReadBlog() {
        $("#content .section-recent-blog ").$(".section-wrapper").scrollTo();
        $("#content .section-recent-blog ").$(".section-wrapper .btn").click();
        return this;
    }

}
