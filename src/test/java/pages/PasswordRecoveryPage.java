package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PasswordRecoveryPage extends BasePage{
    public final By REQUEST_NEW_PASSWORD_BUTTON = By.partialLinkText("Request"),
            RESET_PASSWORD_BUTTON = By.xpath("//button[text() = 'Reset Password']");

    public void requestNewPassword(){
        $("#FEmail").sendKeys(EMAIL);
        $(REQUEST_NEW_PASSWORD_BUTTON).click();
        //Password Reset: An email has been sent to you with further instructions on resetting your password.
    }

    public void clickOnThePasswordRecoveryLink(){
        open("https://www.mailinator.com/v4/public/inboxes.jsp?to=qa");
        $(By.xpath("//td[contains(text(), 'Final Surge Customer Service')]")).click();
        $(By.xpath("//span[contains(text(), 'Click the following')]/a")).click();
    }

    public void inputNewPassword(String newPassword){
        $("#password_meter").sendKeys(newPassword);
        $("#create_passwordmatch").sendKeys(newPassword);
        $(RESET_PASSWORD_BUTTON).click();
        //проверка надписи о сложности пароля
        //проверка ошибки
    }

    public String getMessageResultOfPasswordRecovery(){
        String s1 = $("strong").getAttribute(title());
        String s2 = $(".alert").getAttribute(title());
        return s1+s2;
        //Success: Your password was successfully changed. You can now log into your account.
    }
}
