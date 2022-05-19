package pages;

import org.openqa.selenium.By;
import utils.checkBox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserProfilePage extends BasePage {
    String BoxHeaderName = "//h4[text() = '%s']",
            editButton = "//h4[text() = '%s']//following::div//span";

    public void openPage() {
        open("https://log.finalsurge.com/UserProfile.cshtml");
    }

    public void editUserProfile(String firstName, String lastName, String gender, String birthday, String weight, String type, String country,
                                String region, String city, String zipCode) {
        $(By.xpath(String.format(editButton, "User Profile"))).click();
        $("#fname").clear();
        $("#fname").sendKeys(firstName);
        $("#lname").clear();
        $("#lname").sendKeys(lastName);
        checkBox.clickCheckBox(gender);
        $("[name=BDay]").clear();
        $("[name=BDay]").sendKeys(birthday);
        $("#Weight").clear();
        $("#Weight").sendKeys(weight);
        checkBox.clickCheckBox(type);
        $("[name='Country']").selectOptionContainingText(country);
        $("[name='Region']").selectOptionContainingText(region);
        $("#City").clear();
        $("#City").sendKeys(city);
        $("#Zip").clear();
        $("#Zip").sendKeys(zipCode);
    }

    public void clickSaveButton() {//не работает для SECURITY SETTINGS
        $("[name='btnSubmitSettings']").click();
       // $("[name='btnSubmit']").click();
    }

    public void clickCanselButton() {//не работает для SECURITY SETTINGS
        $("a.btn").click();
    }

    public String getParameter(String nameParameter) {
        return $(By.xpath(String.format("//small[text()='%s:']/ancestor::p", nameParameter))).text();
    }

    public void editUserSettings(String primarySport, String language, String timeZone, String measurementUnits, String timeDisplay, String dateDisplay, String startOfWeek,
                                 String emailUpcoming, String timeOfEmail, String textMessageWorkouts, String phoneNumber, String phoneCarrier, String screenLayout,
                                 String sendEmailUpdates, String coachingFunctionality) {
        $(By.xpath(String.format(editButton, "User Settings"))).click();
        $("[name='PSport']").selectOptionContainingText(primarySport);
        checkBox.clickCheckBox(language);
        $("#TZone").selectOptionContainingText(timeZone);
        checkBox.clickCheckBox(measurementUnits);
        checkBox.clickCheckBox(timeDisplay);
        checkBox.clickCheckBox(dateDisplay);
        checkBox.clickCheckBox(startOfWeek);
        checkBox.clickCheckBoxForName(emailUpcoming, "Email");
        $("#EmailTime").selectOptionContainingText(timeOfEmail);
        checkBox.clickCheckBoxForName(textMessageWorkouts, "Text Message");
        $("#phonenum").clear();
        $("#phonenum").sendKeys(phoneNumber);
        $("#PhoneCarrier").selectOptionContainingText(phoneCarrier);
        checkBox.clickCheckBox(screenLayout);
        checkBox.clickCheckBox(sendEmailUpdates);
        checkBox.clickCheckBox(coachingFunctionality);
    }
}

//    $("[for=Email]").getAttribute(title());//asser email
//        $("[href=EmailAddressEdit]").click();//для восстановление пароля
//
//        $("[name=Country]").click();//клин на список country