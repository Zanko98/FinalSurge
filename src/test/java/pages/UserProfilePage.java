package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.checkBox.clickCheckBox;
import static utils.checkBox.clickCheckBoxForName;

public class UserProfilePage extends BasePage {
    String editButton = "//h4[text() = '%s']//following::div//span";

    @Step("open page UserProfile")
    public void openPage() {
        open("https://log.finalsurge.com/UserProfile.cshtml");
    }

    @Step("edit user profile")
    public void editUserProfile(String firstName, String lastName, String gender, String birthday, String weight, String type, String country,
                                String region, String city, String zipCode) {
        $(By.xpath(String.format(editButton, "User Profile"))).click();
        $("#fname").clear();
        $("#fname").sendKeys(firstName);
        $("#lname").clear();
        $("#lname").sendKeys(lastName);
        clickCheckBox(gender);
        $("[name=BDay]").clear();
        $("[name=BDay]").sendKeys(birthday);
        $("#Weight").clear();
        $("#Weight").sendKeys(weight);
        clickCheckBox(type);
        $("[name='Country']").selectOptionContainingText(country);
        $("[name='Region']").selectOptionContainingText(region);
        $("#City").clear();
        $("#City").sendKeys(city);
        $("#Zip").clear();
        $("#Zip").sendKeys(zipCode);
    }

    @Step("click on the save button")
    public void clickSaveButton() {
        $("[name='btnSubmit']").submit();
    }

    @Step("click on the save button")
    public void clickSaveChangesButton() {
        $("[name='btnSubmitSettings']").submit();
    }

    public String getParameter(String nameParameter) {
        return $(By.xpath(String.format("//small[text()='%s:']/ancestor::p", nameParameter))).text();
    }

    @Step("edit user settings")
    public void editUserSettings(String primarySport, String language, String timeZone, String measurementUnits, String timeDisplay, String dateDisplay, String startOfWeek, String emailUpcoming,
                                 String timeOfEmail, String textMessageWorkouts, String phoneNumber, String phoneCarrier, String screenLayout, String sendEmailUpdates, String coachingFunctionality) {

        $(By.xpath(String.format(editButton, "User Settings"))).click();
        $("[name='PSport']").selectOptionContainingText(primarySport);
        clickCheckBox(language);
        $("#TZone").selectOptionContainingText(timeZone);
        clickCheckBox(measurementUnits);
        clickCheckBox(timeDisplay);
        clickCheckBox(dateDisplay);
        clickCheckBox(startOfWeek);
        clickCheckBoxForName(emailUpcoming, "Email");
        $("#EmailTime").selectOptionContainingText(timeOfEmail);
        clickCheckBoxForName(textMessageWorkouts, "Text Message");
        $("#phonenum").clear();
        $("#phonenum").sendKeys(phoneNumber);
        $("#PhoneCarrier").selectOptionContainingText(phoneCarrier);
        clickCheckBox(screenLayout);
        clickCheckBox(sendEmailUpdates);
        clickCheckBox(coachingFunctionality);
    }
}