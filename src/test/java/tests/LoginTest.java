package tests;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{

    @DataProvider(name = "хз LoginTest")
    public Object[][] inputForLoginTest() {
        return new Object[][]{
                {"", "bla", "Please enter your e-mail address."},
                {"qa@mailinator.com", "", "Please enter a password."},
                {"!@#$%^&*()_+", "bla", "Please enter a valid email address."},
                {"", "bla", "Please enter your e-mail address."},
        };
    }

    @Test(dataProvider = "хз LoginTest")
    public void LoginTest (String login, String password, String error) {
        loginPage.login(login, password);
        assertEquals(loginPage.getErrorMessage(),error);
    }

    @Test
    public void LoginOfUnregisterUserTest () {
        loginPage.login(EMAIL, "bla");
        assertEquals(loginPage.getErrorMessageInvalidUser(),"Invalid login credentials. Please try again.");
    }

    @Test
    public void LogOutButtonTest () {//можно перенести в класс Title
        loginPage.login(EMAIL, PASSWORD);
        titlePage.logOut();
        assertEquals($(By.xpath("//div[@class='panel']/p")).getText(), "Account Login");
    }
}
