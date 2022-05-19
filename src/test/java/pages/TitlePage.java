package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TitlePage extends BasePage{

    public void logOut() {
        $(By.linkText("Logout")).click();
        $(By.linkText("Account Login")).click();
    }
}
