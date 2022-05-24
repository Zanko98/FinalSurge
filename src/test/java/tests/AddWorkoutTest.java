package tests;

import dto.Workout.Run;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    @DataProvider(name = "хз createRunningWorkout")
    public Object[][] inputForEditUserProfile() {
        return new Object[][]{//runType,data,timeOfDay,name,description,showDistance,plannedDistance,planedDistType,planedDuration,distance,distType,duration,paceType,*reps,*advDistance,*advDistType,*advDuration,markAsRace,overallPlace,ageGroupPlace,feel,effort,minHR,avgHR,maxHR,kCal
                {"basic", "21/5/2022", "6:00 AM", "bla", "blab", "yes", "10", "km", "1:1", "0,1", "km", "1:1", "mi", "", "", "", "", "yes", "0", "0", "Good", "2 (Light)", "1", "1", "1", "1", ""},
                {"basic", "", "06:00 AM", "", "", "no", "", "", "", "", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*Please enter a valid Workout Date."},
                {"basic", "21/5/2022", "0", "", "", "no", "", "mi", "", "", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*Please enter a valid Time of Day."},
                {"basic", "21/5/2022", "", "", "", "no", "", "", "", "!@#$%^&*()_+", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*Please enter a valid Distance."},
                {"basic", "21/5/2022", "", "", "", "no", "", "", "", "", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "0,1", "", "", "",
                        "*Please enter a valid Integer for Minimum Heartrate (no decimals)."},
                {"basic", "21/5/2022", "", "", "", "no", "", "", "", "", "km", "1:1", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "0,1", "", "",
                        "*Please enter a valid Integer for Average Heartrate (no decimals)."},
                {"basic", "21/5/2022", "", test100 + test100, "", "no", "", "", "", "", "km", "1:1", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "0,1", "",
                        "*Please enter a valid Integer for Maximum Heartrate (no decimals)."},
                {"basic", "21/5/2022", "", "", test1000 + test1000 + test1000 + test100 + test100, "no", "", "", "", "", "km", "1:1", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "0,1",
                        "*Please enter a valid Integer for Calories Burned (no decimals)."},
                {"basic", "21/5/2022", "", "", test1000 + test1000 + test1000 + test100 + test100 + 1, "no", "", "", "", "", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*The Workout Description cannot be more than 3200 characters."},
                {"basic", "21/5/2022", "", test100 + test100 + 1, "", "no", "", "", "", "", "km", "", "mi", "", "", "", "", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*The Workout Name cannot be more than 200 characters."},

                {"advanced", "21/5/2022", "08:00 PM", "", "", "yes", "0", "mi", "1:1", "", "", "", "1", "22", "1:1", "m", "kph", "yes", "100000", "100000", "Great", "2 (Light)", "0", "0", "0", "0", ""},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "1:1", "m", "kph", "no", "", "", "Good", "2 (Light)", "301", "300", "299", "1",
                        "*Minimum Heartrate cannot be greater than 300."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "300", "301", "300", "1",
                        "*Average Heartrate cannot be greater than 300."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "299", "299", "301", "3",
                        "*Maximum Heartrate cannot be greater than 300."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "-1", "", "", "",
                        "*Minimum Heartrate cannot be less than 0."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "", "-1", "", "",
                        "*Average Heartrate cannot be less than 0."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "", "", "-1", "",
                        "*Maximum Heartrate cannot be less than 0."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "", "", "", "-1",
                        "*Calories Burned cannot be less than 0."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "yes", "100001", "", "Good", "2 (Light)", "", "", "", "",
                        "*Overall Place cannot be greater than 100000."},
                {"advanced", "21/5/2022", "", "", "", "", "", "", "", "", "", "", "", "2", "", "m", "yes", "", "100001", "Good", "2 (Light)", "", "", "", "",
                        "*Age Group Place cannot be greater than 100000."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "m", "yes", "", "-1", "Good", "2 (Light)", "", "", "", "",
                        "*Age Group Place cannot be less than 1."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "", "2", "", "yd", "yes", "-1", "", "Good", "2 (Light)", "", "", "", "",
                        "*Overall Place cannot be less than 1."},
                {"advanced", "21/5/2022", "", "", "", "yes", "", "yd", "9999999", "", "", "", "", "2", "", "m", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*Please enter a valid Set #1 Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"advanced", "21/5/2022", "", "", "", "yes", "", "m", "9999", "", "", "", "", "2", "", "km", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "*Please enter a valid Planned Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"advanced", "21/5/2022", "", "", "", "no", "", "", "", "", "", "", "300", "", "", "mi", "no", "", "", "Good", "2 (Light)", "", "", "", "",
                        "Set #1 Rep Amount cannot be greater than 299."}
        };
    }

    @Test(dataProvider = "хз createRunningWorkout")
    public void createRunningWorkout(String runType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                     String planedDistType, String planedDuration, String distance, String distType, String duration, String reps, String paceType,
                                     String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort, String minHR, String avgHR,
                                     String maxHR, String kCal, String error) {

        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType("Run");
        addWorkoutPage.createRunWorkout(runType, Run.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .showDistance(showDistance)
                .plannedDistance(plannedDistance)
                .planedDistType(planedDistType)
                .planedDuration(planedDuration)
                .distance(distance)//9
                .distType(distType)
                .duration(duration)//13
                .reps(reps)
                .paceType(paceType)
                .markAsRace(markAsRace)
                .overallPlace(overallPlace)
                .ageGroupPlace(ageGroupPlace)
                .feel(feel)
                .effort(effort)
                .minHR(minHR)//3
                .avgHR(avgHR)//3
                .maxHR(maxHR)//3
                .kCal(kCal)//8
                .build());
        titlePage.logOut();
    }
}
