package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public final By LOGIN_BUTTON = By.xpath("//button[text() = 'Login']"),
            SIGN_UP_BUTTON = By.partialLinkText(" Sign up"),
            PASSWORD_RECOVERY_BUTTON = By.partialLinkText("Forgot?");

    public void login(String email, String password) {
        open("https://log.finalsurge.com/");
        $("#login_name").sendKeys(email);
        $("#login_password").sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public String getErrorMessage () {
       return $(By.xpath("//label[@class = 'error']")).getText();
    }

    public String getErrorMessageInvalidUser () {
        return $(By.xpath("//div[@class='alert alert-error']/strong")).getText();
    }

    public void signUpButtonClick() {
        $(SIGN_UP_BUTTON).click();
    }

    public void passwordRecoveryClick() {
        $(PASSWORD_RECOVERY_BUTTON).click();
    }
}
