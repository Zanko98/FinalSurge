package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserProfilePage extends BasePage {
    String BoxHeaderName = "//h4[text() = '%s']",
            editButton = "//h4[text() = '%s']//following::div//span";

    public void openPage() {
        open("https://log.finalsurge.com/UserProfile.cshtml");
    }

    public void editUserProfile(String firstName, String lastName, String gender, String birthday, String weight,String type, String country,
                                String region, String city, String zipCode) {
        $(By.xpath(String.format(editButton, "User Profile"))).click();
        $("#fname").clear();
        $("#fname").sendKeys(firstName);
        $("#lname").clear();
        $("#lname").sendKeys(lastName);
        $(String.format("#%s", gender)).click();//для male or female
        $("[name=BDay]").clear();
        $("[name=BDay]").sendKeys(birthday);
        $("#Weight").clear();
        $("#Weight").sendKeys(weight);
        if (type.equals("kg"))    $("#optionsRadios4").click();
        else $("#optionsRadios3").click();
        $("[name='Country']").selectOptionContainingText(country);
        $("[name='Region']").selectOptionContainingText(region);
        $("#City").clear();
        $("#City").sendKeys(city);
        $("#Zip").clear();
        $("#Zip").sendKeys(zipCode);
    }

    public void clickSaveButton() {//не работает для SECURITY SETTINGS
        $("[name='btnSubmit']").click();
    }

    public void clickCanselButton() {//не работает для SECURITY SETTINGS
        $("a.btn").click();
    }

    public String getParameter(String nameParameter) {
        return $(By.xpath(String.format("//small[text()='%s:']/ancestor::p", nameParameter))).text();
    }

}
//    $("[for=Email]").getAttribute(title());//asser email
//        $("[href=EmailAddressEdit]").click();//для восстановление пароля
//
//        $("[name=Country]").click();//клин на список country