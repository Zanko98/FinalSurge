package pages;

import com.codeborne.selenide.Condition;
import dto.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewAccountPage extends BasePage {
    public final By LOGIN_BUTTON = By.partialLinkText(" Login here."),
            PRIVACY_POLICY_BUTTON = By.linkText("Privacy Policy"),
            TERMS_OF_USE_BUTTON = By.linkText("Terms of Use"),
          //  PROGRESS_DANGER = By.cssSelector(".pwdText"),
            CREATE_BUTTON = By.xpath("//button[text() = 'Create New Account']");

    public void createNewAccount(Account account) {
        open("login.cshtml");
        $(CREATE_BUTTON).shouldBe(Condition.visible);
        $("#create_first").sendKeys(account.getFirstName());
        $("#create_last").sendKeys(account.getLastName());
        $("#create_email").sendKeys(account.getEmail());
        $("#create_timezone").click();
        //доделать выбор по зоне
        $("#password_meter").sendKeys(account.getPassword());
        $("#create_passwordmatch").sendKeys(account.getRepeatPassword());
        $(CREATE_BUTTON).click();
    }

    public void termsOfUseButtonClick() {
        $(TERMS_OF_USE_BUTTON).click();
    }

    public void privacyPolicyButtonClick() {
        $(PRIVACY_POLICY_BUTTON).click();
    }

    public void loginButtonClick() {
        $(LOGIN_BUTTON).click();
    }
}
