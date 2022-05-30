package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    public final String EMAIL = "qa@mailinator.com",
            PASSWORD = "!QAZ1qaz";
    String test100 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
            test1000 = test100+test100+test100+test100+test100+test100+test100+test100+test100+test100;
    LoginPage loginPage;
    NewAccountPage newAccountPage;
    PasswordRecoveryPage passwordRecoveryPage;
    UserProfilePage userProfilePage;
    TitlePage titlePage;
    WorkoutBasePage workoutBasePagePage;
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
        workoutBasePagePage = new WorkoutBasePage();
        addWorkoutPage = new AddWorkoutPage();
    }
}
