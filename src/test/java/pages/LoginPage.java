package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    public final By LOGIN_BUTTON = By.xpath("//button[text() = 'Login']");

    @Step("log in")
    public void login(String email, String password) {
        log.info("Log in with email: {}", email);
        open("https://log.finalsurge.com/");
        $("#login_name").sendKeys(email);
        $("#login_password").sendKeys(password);
        $(LOGIN_BUTTON).click();
    }
}
