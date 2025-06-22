package autotests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import components.FooterMenu;
import components.HeaderMenu;
import components.SocialNetworks;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.home.BodyLinks;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("mainPage")
public class MainPageButtonLinksTest {
    @BeforeAll
    static void startsConfiguration() {
        Configuration.browserSize = "1920x1200";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVNC",true);

            /* How to enable video recording */
            put("enableVideo", true);
        }});
       // RemoteWebDriver driver = new RemoteWebDriver(new URL("https://selenoid.autotests.cloud/wd/hub"), options);




        Selenide.open("https://akvelon.com.ua/");




    }

    @BeforeEach
    void returnAtHomePage() {
        $("#masthead .site-header__branding").click();
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Testing the menu in the header")
    @CsvSource({
            "About us,akvelon.com.ua/about-akvelon",
            "Our projects,akvelon.com.ua/projects",
            "Blog,akvelon.com.ua/blog",
            "Contact,akvelon.com.ua/contacts",
    })
    @ParameterizedTest(name = "Name button from menu {0}, control link {1}")
    void testButtonFromHeaderSiteNavigator(String namePages, String pageUrl) {
        HeaderMenu steep = new HeaderMenu();
        steep.selectNamePagesInSiteNavigator(namePages);
        steep.assertToOpenPage(pageUrl);
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Testing the modal-menu in the header")
    @CsvSource({
            "Vacancies,akvelon.com.ua/vacancy",
            "Relocate,akvelon.com.ua/relocate",
            "Internship,akvelon.com.ua/internship",

    })
    @ParameterizedTest(name = "Name button from menu {0}, control link {1}")
    void testButtonFromHeaderSectionCareers(String namePages, String pageUrl) {
        HeaderMenu steep = new HeaderMenu();
        steep.selectButtonFromSectionCareers(namePages);
        steep.assertToOpenPage(pageUrl);

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Кирилица Сhecking the opening of the CV unloading form")
    @Test
    void testOpenSendCVForm() {
        HeaderMenu steep = new HeaderMenu();
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Нажать на кропку", () -> {
            steep.clickForButtonSendCV();
        });
        step("нажать на еще одну",()-> {
            steep.clickForButtonSendCV();
        });
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Сhecking the opening of the subscription form")
    @Test
    void testOpenSubscribeForm() {
        BodyLinks steep = new BodyLinks();
        steep.clickForSubscribeForm();
        steep.assertToOpenSubscribeForm();
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("checking the transition to the donation page")
    @Test
    void testOpenDonatePage() {
        BodyLinks steep = new BodyLinks();
        steep.clickForDonateButton()
                .assertToOpenPageInNewWindow("www.helpukraine.akvelon.org");
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("checking the transition to the vacancies page by clicking the Vacancies button")
    @Test
    void testOpenPageVacancyForVacanciesButton() {
        BodyLinks steep = new BodyLinks();
        steep.clickForButtonSeeVacancies()
                .asserToOpenPageInThisWindow("akvelon.com.ua/vacancy");
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Go to the projects page, click on our projects")
    @Test
    void testOpenPageProjectForOurProjectButton() {
        BodyLinks steep = new BodyLinks();
        steep.clickForButtonOurProjects()
                .asserToOpenPageInThisWindow("akvelon.com.ua/projects");

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Go to the Vacancies page, from the Career section")
    @Test
    void testOpenPageVacancyForButtonLearnMoreSectionCareers() {
        BodyLinks steep = new BodyLinks();
        steep.clickForButtonLearnMoreSectionCareers()
                .asserToOpenPageInThisWindow("akvelon.com.ua/vacancy");

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Checking the transition to pages from the collection of the career section")
    @CsvSource({
            "/internship/,akvelon.com.ua/internship",
            "/relocate/,akvelon.com.ua/relocate",
            "/vacancy/?hot=1,akvelon.com.ua/vacancy/?hot=1",

    })
    @ParameterizedTest(name = "Name button from menu {0}, control link {1}")
    void testOpenPagesForButtonSectionCareers(String namePages, String pageUrl) {
        BodyLinks steep = new BodyLinks();
        steep.clickForButtonInternshipSectionCareers(namePages)
                .asserToOpenPageInThisWindow(pageUrl);
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Сhecking the opening of the subscription form from the vacancies section")
    @Test
    void testOpenFormSubscribeOnVacancies() {
        BodyLinks steep = new BodyLinks();
        steep.clickForSubscribeVacanciesButton()
                .assertToOpenSubscribeForm();

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("checking the opening of the blog from the blog section")
    @Test
    void testOpenPageBlogForButtonReadBlog() {
        BodyLinks steep = new BodyLinks();
        steep.clickForButtonReadBlog()
                .asserToOpenPageInThisWindow("akvelon.com.ua/blog");
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Testing the menu in the footer")
    @CsvSource({
            "About us,akvelon.com.ua/about-akvelon",
            "Our projects,akvelon.com.ua/projects",
            "Blog,akvelon.com.ua/blog",
            "Contact,akvelon.com.ua/contacts",
    })
    @ParameterizedTest(name = "Name button from menu {0}, control link {1}")
    void testButtonFromFooterSiteNavigator(String namePages, String pageUrl) {
        FooterMenu steep = new FooterMenu();
        steep.selectNamePagesInSiteNavigator(namePages);
        steep.assertToOpenPage(pageUrl);
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Testing the modal-menu in the footer")
    @CsvSource({
            "Vacancies,akvelon.com.ua/vacancy",
            "Relocate,akvelon.com.ua/relocate",
            "Internship,akvelon.com.ua/internship",

    })
    @ParameterizedTest(name = "Name button from menu {0}, control link {1}")
    void testButtonFromFooterSectionCareers(String namePages, String pageUrl) {
        FooterMenu steep = new FooterMenu();
        steep.selectButtonFromSectionCareers(namePages);
        steep.assertToOpenPage(pageUrl);

    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("checking the email button for the mailto attribute")
    @Test
    void testMailtoAttribute() {
        step("Проскролить вниз", () -> {
            $("#footer-menu").scrollTo();
        });
        step("Проверить, что елемент видимый", () -> {
            $(".site-footer__row .site-footer__email").shouldBe(visible);
        });
        step("Выполнить проверку", () -> {
            $(".site-footer__row ").$("a[href='mailto:jobua@akvelon.com']").
                    shouldHave(attribute("href", "mailto:jobua@akvelon.com"));
        });
    }

    @Owner("Oleksand Fedorenko")
    @DisplayName("Social network buttons are checked for links")
    @CsvSource({
            "Facebook,https://www.facebook.com/AkvelonUkraine",
            "LinkedIn,https://www.linkedin.com/company/akvelon/",
            "Instagram,https://www.instagram.com/akvelon.ukraine/",
            "Telegram,https://t.me/Akvelon_vacancies",
            "DOU,https://jobs.dou.ua/companies/akvelon-ukraine/"

    })
    @ParameterizedTest(name = "Name button  {0}, control link {1}")
    void testButtonSocialNetworksInFooter(String nameNetwork, String controlLink) {
        SocialNetworks steep = new SocialNetworks();
        steep.openSocialNetworkPage(nameNetwork, controlLink);

    }

}
