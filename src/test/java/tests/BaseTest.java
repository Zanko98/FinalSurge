package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class BaseTest {
    public final String
            EMAIL = "qa@mailinator.com",
            PASSWORD = "!QAZ1qaz";
    LoginPage loginPage;
    UserProfilePage userProfilePage;
    WorkoutBasePage workoutBasePagePage;
    AddWorkoutPage addWorkoutPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        // Configuration.holdBrowserOpen = true;

        loginPage = new LoginPage();
        userProfilePage = new UserProfilePage();
        workoutBasePagePage = new WorkoutBasePage();
        addWorkoutPage = new AddWorkoutPage();
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        $(By.linkText("Logout")).click();
        $(By.linkText("Account Login")).click();
    }
}
