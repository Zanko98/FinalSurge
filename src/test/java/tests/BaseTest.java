package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    public final String EMAIL = "qa@mailinator.com",
            PASSWORD = "!QAZ1qaz";
    LoginPage loginPage;
    NewAccountPage newAccountPage;
    PasswordRecoveryPage passwordRecoveryPage;
    UserProfilePage userProfilePage;
    TitlePage titlePage;
    AddWorkoutPage addWorkoutPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://log.finalsurge.com/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        loginPage = new LoginPage();
        newAccountPage = new NewAccountPage();
        passwordRecoveryPage = new PasswordRecoveryPage();
        userProfilePage = new UserProfilePage();
        titlePage = new TitlePage();
        addWorkoutPage = new AddWorkoutPage();
    }
}
