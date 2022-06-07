package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.AddWorkoutPage;
import pages.LoginPage;
import pages.UserProfilePage;
import pages.WorkoutBasePage;

public class BaseTest {
    public final String
            EMAIL = System.getProperty("email", "qa@mailinator.com"),
            PASSWORD = System.getenv().getOrDefault("password", "!QAZ1qaz");
    LoginPage loginPage;
    UserProfilePage userProfilePage;
    WorkoutBasePage workoutBasePagePage;
    AddWorkoutPage addWorkoutPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome")String browser) {
        Configuration.browser =  browser;
        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        if (System.getProperty("headless", "true").equals("true"))
            Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));

        loginPage = new LoginPage();
        userProfilePage = new UserProfilePage();
        workoutBasePagePage = new WorkoutBasePage();
        addWorkoutPage = new AddWorkoutPage();
    }

    @AfterMethod(alwaysRun = true)
    @Step("close browser")
    public void close() {
        Selenide.closeWebDriver();
    }
}
