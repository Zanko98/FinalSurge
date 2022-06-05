package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.RandomData.randomString;

public class UserProfileTest extends BaseTest {

    @DataProvider(name = "edit UserProfile")
    public Object[][] inputForEditUserProfile() {
        return new Object[][]{
                {"bla", "bla", "Male", "1/1/2000", "4", "kg", "Palau", "Airai", "bla", "la", ""},//                {"!@#$%^&*()_+", "bla", "Male", "0", "4", "kg", "Palau", "Airai", "bla", "la", "Please enter a valid Birthday."},
//                {"bla", "!@#$%^&*()_+", "Male", "", "!@#$%^&*()_+", "kg", "Palau", "Airai", "bla", "la", "Please enter a valid Weight."},
//                {"", "bla", "Female", "1/1/2000", "4", "kg", "Palau", "Airai", "bla", randomString(50), "Please enter a value for First Name."},
//                {"bla", "", "Male", "1/1/2000", "800", "kg", "Palau", "Airai", "!@#$%^&*()_+", "la", "Please enter a value for Last Name."},
//                {"bla", "bla", "Male", "1/1/2000", "0", "kg", "Palau", "Airai", "", "!@#$%^&*()_+", "Weight cannot be less than 1.00."},
//                {"bla", "bla", "Male", "1/1/2000", "801", "kg", "Palau", "Airai", "bla", "", "Weight cannot be greater than 800.00."},
//                {"bla", "bla", "Male", "1/1/2000", "4", "kg", "Palau", "Airai", "bla", randomString(51), "The Zip/Postal Code cannot be more than 50 characters."},
//                {"bla", "bla", "Male", "1/1/2000", "4", "kg", "Palau", "Airai", randomString(201), "", "*The City cannot be more than 200 characters."}
        };
    }

    @Test(dataProvider = "edit UserProfile")
    public void editUserProfile(String firstName, String lastName, String gender, String birthday, String weight, String type, String country,
                                String region, String city, String zipCode, String error) {
        loginPage.login(EMAIL, PASSWORD);
        userProfilePage.openPage();
        userProfilePage.editUserProfile(firstName, lastName, gender, birthday, weight, type, country, region, city, zipCode);
        userProfilePage.clickSaveButton();
        if (error.isEmpty()) {
            assertEquals(userProfilePage.getParameter("Name"), "Name: " + firstName + " " + lastName);
            assertTrue(userProfilePage.getParameter("Gender").equalsIgnoreCase("Gender: " + gender));
            assertEquals(userProfilePage.getParameter("Birthday"), "Birthday: " + birthday);
            assertTrue(userProfilePage.getParameter("Weight").startsWith("Weight: " + weight));
            assertTrue(userProfilePage.getParameter("Weight").endsWith(type));
            assertEquals(userProfilePage.getParameter("Country"), "Country:" + " " + country);
            assertEquals(userProfilePage.getParameter("State"), "State: " + region);
            assertEquals(userProfilePage.getParameter("City"), "City: " + city);
            assertEquals(userProfilePage.getParameter("Zip/Postal Code"), "Zip/Postal Code: " + zipCode);
        } else assertTrue($("div.alert").getText().endsWith(error));
    }

    @DataProvider(name = "edit UserSettings")
    public Object[][] inputForEditUserSettings() {
        return new Object[][]{
//                {"Running", "English", "(GMT-11:00) Samoa", "Imperial", "12 hour", "DD/MM/YYYY", "Monday", "Daily", "1:00 AM", "Never", "", "", "Fixed Layout", "Yes", "Turn Off",
//                        ""},
//                {"Select...", "Deutsch", "(GMT-11:00) Samoa", "Metric", "24 hour", "MM/DD/YYYY", "Sunday", "Daily", "12:00 AM", "Daily", "0123456789", "Alltel", "Fixed Layout", "No", "Turn On",
//                        "*Please enter a value for Primary Sport."},
//                {"Cycling", "English", "Select...", "Metric", "24 hour", "MM/DD/YYYY", "Sunday", "Never", "12:00 AM", "Never", "0123456789", "Alltel", "Fluid Layout (stretches entire with of your screen)", "No", "Turn On",
//                        "Please enter a value for Time Zone."},
//                {"Running", "English", "(GMT-11:00) Samoa", "Metric", "24 hour", "YYYY/MM/DD", "Sunday", "Daily", "1:00 AM", "Daily", "", "Alltel", "Fixed Layout", "No", "Turn On",
//                        "*If you are choosing to have your upcoming workouts text messaged to you, you must enter a Cell Phone Number."},
//                {"Skiing", "English", "(GMT-11:00) Samoa", "Metric", "24 hour", "YYYY/MM/DD", "Sunday", "Daily", "12:00 AM", "Daily", "123456789", "Alltel", "Fixed Layout", "No", "Turn On",
//                        "*The Cell Phone Number cannot be less than 10 characters."},
//                {"Running", "English", "(GMT-11:00) Samoa", "Metric", "24 hour", "MM/DD/YYYY", "Sunday", "Daily", "1:00 AM", "Daily", "0123456789", "Select...", "Fixed Layout", "No", "Turn On",
//                        "*If you are choosing to have your upcoming workouts text messaged to you, you must select a Cell Phone Carrier."},
                {"Surfing", "English", "(GMT-11:00) Samoa", "Metric", "12 hour", "DD/MM/YYYY", "Monday", "Daily", "1:00 AM", "Daily", "012345678911", "Alltel", "Fixed Layout", "No", "Turn On",
                        "*The Cell Phone Number cannot be more than 11 characters."},
        };
    }

    @Test(dataProvider = "edit UserSettings")
    public void editUserSettings(String primarySport, String language, String timeZone, String measurementUnits, String timeDisplay, String dateDisplay, String startOfWeek,
                                 String emailUpcoming, String timeOfEmail, String textMessageWorkouts, String phoneNumber, String phoneCarrier, String screenLayout, String sendEmailUpdates,
                                 String coachingFunctionality, String error) {
        loginPage.login(EMAIL, PASSWORD);
        userProfilePage.openPage();
        userProfilePage.editUserSettings(primarySport, language, timeZone, measurementUnits, timeDisplay, dateDisplay, startOfWeek, emailUpcoming, timeOfEmail, textMessageWorkouts,
                phoneNumber, phoneCarrier, screenLayout, sendEmailUpdates, coachingFunctionality);
        userProfilePage.clickSaveChangesButton();
        if (error.isEmpty()) {
            assertEquals(userProfilePage.getParameter("Primary Sport"), "Primary Sport: " + primarySport);
            assertTrue(userProfilePage.getParameter("Language").equalsIgnoreCase("Language: " + language));
            assertEquals(userProfilePage.getParameter("Measurement Units"), "Measurement Units: " + measurementUnits);
            assertEquals(userProfilePage.getParameter("Time Display"), "Time Display: " + timeDisplay);
            assertEquals(userProfilePage.getParameter("Date Display"), "Date Display: " + dateDisplay);
            assertEquals(userProfilePage.getParameter("Start of Week"), "Start of Week: " + startOfWeek);
            assertEquals(userProfilePage.getParameter("Email Upcoming Workouts"), "Email Upcoming Workouts: " + emailUpcoming + " - " + timeOfEmail);
            assertEquals(userProfilePage.getParameter("Text Message Upcoming Workouts"), "Text Message Upcoming Workouts: " + textMessageWorkouts);
            assertEquals(userProfilePage.getParameter("Screen Layout"), "Screen Layout: " + screenLayout);
            assertEquals(userProfilePage.getParameter("Send Email Updates"), "Send Email Updates: " + sendEmailUpdates);
            assertEquals(userProfilePage.getParameter("Coaching Functionality"), "Coaching Functionality: " + coachingFunctionality.substring(5));
        } else assertTrue($("div.alert").getText().contains(error));
    }
}
