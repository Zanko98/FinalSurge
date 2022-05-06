package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public final By LOGIN_BUTTON = By.xpath("//button[text() = 'Login']"),
            SIGN_UP_BUTTON = By.partialLinkText(" Sign up"),
            PASSWORD_RECOVERY_BUTTON = By.partialLinkText("Forgot?");
    //#login_remember -- checkbox

    public void login() {
        open("https://log.finalsurge.com/");
        $("#login_name").sendKeys(EMAIL);
        $("#login_password").sendKeys(PASSWORD);
        $(LOGIN_BUTTON).click();
    }
    public void logout() {//перенести потом в нужный кдасс из LoginPage
        $(By.linkText("Logout")).click();
    }

    public void signUpButtonClick() {
        $(SIGN_UP_BUTTON).click();
    }

    public void passwordRecoveryClick() {
        $(PASSWORD_RECOVERY_BUTTON).click();
    }
}
