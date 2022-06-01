package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    public final By LOGIN_BUTTON = By.xpath("//button[text() = 'Login']");

    public void login(String email, String password) {
        open("https://log.finalsurge.com/");
        $("#login_name").sendKeys(email);
        $("#login_password").sendKeys(password);
        $(LOGIN_BUTTON).click();
    }
}
