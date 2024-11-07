package components;



import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SocialNetworks {

    public SocialNetworks openSocialNetworkPage(String nameNetwork, String controlLink) {
        $("#footer-menu").scrollTo();
        $(".site-footer__bottom .site-footer__social").$("a[aria-label='" + nameNetwork + "']").shouldBe(visible);
        $(".site-footer__bottom .site-footer__social").$("a[aria-label='" + nameNetwork + "']")
                .shouldHave(attribute("href", controlLink));

        return this;
    }


}
