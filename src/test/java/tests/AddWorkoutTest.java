package tests;

import dto.Workout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.RandomData.randomDate;
import static utils.RandomData.randomString;

public class AddWorkoutTest extends BaseTest {

  /*  @DataProvider(name = "Run and Swim and Cross")
    public Object[][] inputForCreateRunOrSwimOrCross() {
        return new Object[][]{
                {"Run", "basic", randomDate(), "6:00 AM", "", "!@#$%^&*()_+", "yes", "10", "km", "0:01", "min/mi", "", "0", "km", "1:01", "yes", "", "99999", "Good", "2 (Light)", "300", "0", "", "1", ""},
                {"Run", "basic", randomDate(), "", "", "", "yes", "!@#$%^&*()_+", "m", "", "min/km", "", "", "mi", "", "no", "", "", "Great", "3 (Light)", "", "", "", "", "*Please enter a valid Planned Distance."},
                {"Run", "basic", randomDate(), "", "", "", "no", "", "", "", "mph", "", "", "yd", "", "yes", "-1", "", "Great", "2 (Light)", "", "", "", "", "*Overall Place cannot be less than 1."},
                {"Run", "basic", randomDate(), "", "", "", "no", "", "", "", "kph", "", "", "km", "", "yes", "100001", "", "Great", "2 (Light)", "", "", "", "", "*Overall Place cannot be greater than 100000."},
                {"Run", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "-1", "", "yd", "", "no", "", "", "Normal", "2 (Light)", "", "", "", "", "*Set #1 Rep Amount cannot be less than 1."},
                {"Run", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "m", "", "no", "", "", "Normal", "Select...", "", "", "", "-1", "*Calories Burned cannot be less than 0."},
                {"Run", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "m", "", "no", "", "", "Poor", "2 (Light)", "", "", "301", "", "*Maximum Heartrate cannot be greater than 300."},
                {"Run", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "!@#$%^&*()_+", "m", "", "no", "", "", "Poor", "3 (Light)", "", "", "", "", "*You must have at least one Set or Rep Distance and/or Duration for Set #1."},
                {"Run", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "mi", "", "yes", "", "0,1", "Terrible", "3 (Light)", "", "", "", "", "*Please enter a valid Integer for Age Group Place (no decimals)."},
                {"Swim", "basic", randomDate(), "8:00 PM", "", "", "yes", "", "m", "0", "min/1500m", "", "", "mi", "000000", "yes", "100000", "", "Normal", "3 (Light)", "", "", "", "0", ""},
                {"Swim", "basic", randomDate(), "", "", "", "yes", "", "m", "9999999", "min/100m", "", "", "km", "", "no", "", "", "Poor", "3 (Light)", "", "", "", "", "*Please enter a valid Planned Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"Swim", "basic", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "", "mi", "", "yes", "", "100001", "Good", "2 (Light)", "", "", "", "", "*Age Group Place cannot be greater than 100000."},
                {"Swim", "basic", randomDate(), "", "", "", "no", "", "", "", "mph", "", "!@#$%^&*()_+", "mi", "", "no", "", "", "Good", "3 (Light)", "", "", "", "", "*Please enter a valid Distance."},
                {"Swim", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "mi", "", "no", "", "", "Good", "2 (Light)", "", "", "", "0,1", "*Please enter a valid Integer for Calories Burned (no decimals)."},
                {"Swim", "advanced", randomDate(), "", "", "", "yes", "-1", "km", "", "", "", "", "yd", "", "no", "", "", "Terrible", "Select...", "", "", "", "", "*The Planned Distance cannot be less than 0.00."},
                {"Swim", "advanced", randomDate(), "", "", "", "yes", "", "mi", "1", "", "300", "", "km", "", "no", "", "", "Good", "Select...", "", "", "", "", "*Set #1 Rep Amount cannot be greater than 299."},
                {"Swim", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "m", "55:55:61", "no", "", "", "Great", "Select...", "", "", "", "", "*Please enter a valid Set #1 Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"Cross Training", "", randomDate(), "", "", "", "yes", "0,1", "yd", "55:55:59", "min/1500m", "", "", "yd", "55:55:59", "yes", "99999", "", "Poor", "Select...", "", "1", "299", "", ""},
                {"Cross Training", "", randomDate(), "", "", "", "no", "", "", "", "min/100m", "", "", "km", "", "no", "", "", "Good", "Select...", "", "301", "", "", "*Average Heartrate cannot be greater than 300."},
                {"Cross Training", "", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "", "mi", "", "yes", "", "-1", "Normal", "Select...", "", "", "", "", "*Age Group Place cannot be less than 1."},
                {"Cross Training", "", randomDate(), "", "", "", "yes", "", "m", "55:55:60", "mph", "", "", "yd", "", "no", "", "", "Terrible", "Select...", "", "", "", "", "*Please enter a valid Planned Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"Cross Training", "", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "-1", "km", "", "no", "", "", "Normal", "2 (Light)", "", "", "", "", "*The Distance cannot be less than 0.00."},
                {"Cross Training", "", randomDate(), "", "", "", "no", "", "", "", "min/1500m", "", "", "km", "", "no", "", "", "Good", "Select...", "0,1", "", "", "", "*Please enter a valid Integer for Minimum Heartrate (no decimals)."},
                {"Cross Training", "", randomDate(), "", "", "", "no", "", "", "", "min/100m", "", "", "km", "", "no", "", "", "Great", "2 (Light)", "", "-1", "", "", "*Average Heartrate cannot be less than 0."}
        };
    }

    @Test(dataProvider = "Run and Swim and Cross")
    public void createRunOrSwimOrCross(String typeWorkout, String activityType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                       String planedDistType, String planedDuration, String paceType, String reps, String distance, String distType, String duration, String markAsRace,
                                       String overallPlace, String ageGroupPlace, String feel, String effort, String minHR, String avgHR, String maxHR, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(typeWorkout);
        addWorkoutPage.createRunOrSwimOrCross(activityType, Workout.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .showDistance(showDistance)
                .plannedDistance(plannedDistance)
                .planedDistType(planedDistType)
                .planedDuration(planedDuration)
                .distance(distance)
                .distType(distType)
                .duration(duration)
                .reps(reps)
                .paceType(paceType)
                .markAsRace(markAsRace)
                .overallPlace(overallPlace)
                .ageGroupPlace(ageGroupPlace)
                .feel(feel)
                .effort(effort)
                .minHR(minHR)
                .avgHR(avgHR)
                .maxHR(maxHR)
                .kCal(kCal)
                .build());
        addWorkoutPage.assertNameOrErrorWorkout(typeWorkout, name, error);
    }

*/
    @DataProvider(name = "RestDay and Recovery and Other and StrengthTraining")
    public Object[][] inputForCreateRestDayAndRecovery() {
        return new Object[][]{
                {"Rest Day", randomDate(), "", "", "", "", "", "", ""},
                {"Rest Day", randomDate(), "", randomString(201), "", "", "", "", "*The Workout Name cannot be more than 200 characters."},
                {"Recovery/Rehab", randomDate(), "", "", "", "", randomString(200), "*", ""},
                {"Recovery/Rehab", "", "", "", "", "", "", "", "*Please enter a value for Workout Date."},
                {"Strength Training", randomDate(), "", "!@#$%^&*()_+", "", "0", "Terrible", "Select...", ""},
                {"Strength Training", randomDate(), "", "", "", "55:55:60", "Great", "2 (Light)", "*Please enter a valid Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"Other", randomDate(), "", "", randomString(3200), "", "", "", ""},
                {"Other", randomDate(), "0", "", "", "", "", "", "*Please enter a valid Time of Day."},
                {"Other", randomDate(), "", "", randomString(3201), "", "", "", "*The Workout Description cannot be more than 3200 characters."}
        };
    }

    @Test(dataProvider = "RestDay and Recovery and Other and StrengthTraining")
    public void createRestDayAndRecovery(String typeWorkout, String data, String timeOfDay, String name, String description, String duration, String feel, String effort, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(typeWorkout);
        addWorkoutPage.createRestDayOrRecoveryOrStrengthOrOther(Workout.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .duration(duration)
                .feel(feel)
                .effort(effort)
                .build());
        addWorkoutPage.assertNameOrErrorWorkout(typeWorkout, name, error);
    }
/*
    @DataProvider(name = "Bik and Walk and Transition")
    public Object[][] inputForCreateBikeOrWalkOrTransition() {
        return new Object[][]{
                {"Bike", "advanced", randomDate(), "", "", "", "yes", "0", "m", "", "", "299", "0,1", "m", "000000", "999999999", "ft", "0", "m", "yes", "", "1", "Great", "2 (Light)", "0", "5000", "", "9999", "299", "", "1", "", ""},
                {"Bike", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "km", "", "", "ft", "", "m", "no", "", "", "Great", "3 (Light)", "", "0", "0,1", "", "", "", "", "", "*Please enter a valid Integer for Average Cadence (no decimals)."},
                {"Bike", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "mi", "", "", "ft", "~!@#$%^&*()_+", "m", "no", "", "", "Normal", "Select...", "", "", "", "", "", "", "", "", "*Please enter a valid Elevation Loss."},
                {"Bike", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "yd", "", "", "ft", "", "ft", "no", "", "", "Normal", "Select...", "-1", "", "", "", "", "", "", "", "*Average Wattage cannot be less than 0."},
                {"Bike", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "0", "yd", "", "", "ft", "", "ft", "no", "", "100000", "Normal", "Select...", "", "", "", "", "", "", "", "", "*You must have at least one Set or Rep Distance and/or Duration for Set #1."},
                {"Bike", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "yd", "1:01", "", "ft", "", "ft", "yes", "0,1", "", "Normal", "Select...", "", "", "", "", "", "", "", "", "*Please enter a valid Integer for Overall Place (no decimals)."},
                {"Bike", "basic", randomDate(), "", "", "", "no", "", "", "", "min/1500m", "", "999999999", "km", "", "", "m", "", "ft", "no", "", "", "Poor", "3 (Light)", "", "", "", "", "", "", "0,1", "", "*Please enter a valid Integer for Maximum Heartrate (no decimals)."},
                {"Bike", "basic", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "", "mi", "", "", "m", "", "ft", "no", "", "", "Terrible", "3 (Light)", "", "", "-1", "", "", "", "", "", "*Average Cadence cannot be less than 0."},
                {"Walk", "advanced", randomDate(), "", "", "", "yes", "999999999", "yd", "", "", "1", "99999", "m", "55:55:59", "0,1", "m", "", "ft", "yes", "1", "", "Poor", "Select...", "5000", "499", "0", "", "0", "299", "300", "", ""},
                {"Walk", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "m", "", "", "m", "", "ft", "no", "", "", "Good", "2 (Light)", "", "", "", "0,1", "", "", "", "", "*Please enter a valid Integer for Maximum Cadence (no decimals)."},
                {"Walk", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "km", "", "", "ft", "", "m", "no", "", "", "Terrible", "2 (Light)", "5001", "", "", "", "", "", "", "", "*Average Wattage cannot be greater than 5000."},
                {"Walk", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "0", "", "km", "", "", "ft", "", "m", "no", "", "", "Terrible", "3 (Light)", "", "", "", "", "", "", "", "", "*Set #1 Rep Amount cannot be less than 1."},
                {"Walk", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "mi", "!@#$%^&*()_+", "", "ft", "", "m", "no", "", "", "Good", "3 (Light)", "", "-1", "", "", "", "", "", "", "*Maximum Wattage cannot be less than 0."},
                {"Walk", "basic", randomDate(), "", "", "", "no", "", "", "", "kph", "", "", "yd", "", "", "ft", "", "ft", "no", "", "", "Great", "2 (Light)", "", "", "", "", "", "0,1", "", "", "*Please enter a valid Integer for Average Heartrate (no decimals)."},
                {"Walk", "basic", randomDate(), "", "", "", "no", "", "", "", "min/1500m", "", "", "km", "", "~!@#$%^&*()_+", "ft", "", "m", "no", "", "", "Great", "2 (Light)", "", "", "", "", "", "", "", "", "*Please enter a valid Elevation Gain."},
                {"Walk", "basic", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "", "yd", "", "-1", "m", "", "ft", "no", "", "", "Normal", "2 (Light)", "", "", "", "", "", "", "", "", "*Elevation Gain cannot be less than 0.00."},
                {"Transition", "basic", randomDate(), "", "", "", "yes", "", "mi", "000000", "min/km", "", "0,1", "m", "", "", "m", "999999999", "ft", "", "", "", "Poor", "Select...", "499", "", "9999", "0", "1", "300", "0", "", ""},
                {"Transition", "basic", randomDate(), "", "", "", "no", "", "", "", "mph", "", "", "km", "", "", "ft", "", "m", "", "", "", "Good", "2 (Light)", "", "5001", "", "", "", "", "", "", "*Maximum Wattage cannot be greater than 5000."},
                {"Transition", "basic", randomDate(), "", "", "", "no", "", "", "", "kph", "", "", "mi", "", "0", "ft", "", "m", "", "", "", "Terrible", "2 (Light)", "", "", "", "", "", "", "-1", "", "*Maximum Heartrate cannot be less than 0."},
                {"Transition", "basic", randomDate(), "", "", "", "no", "", "", "", "min/100y", "", "", "km", "!@#$%^&*()_+", "", "ft", "", "ft", "", "", "", "Good", "3 (Light)", "", "", "", "-1", "", "", "", "", "*Maximum Cadence cannot be less than 0."},
                {"Transition", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "mi", "", "", "m", "", "ft", "", "", "", "Great", "2 (Light)", "0,1", "", "", "", "", "", "", "", "*Please enter a valid Integer for Average Wattage (no decimals)."},
                {"Transition", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "0,1", "-1", "mi", "", "", "ft", "", "m", "", "", "", "Great", "3 (Light)", "", "", "", "", "", "", "", "", "*Please enter a valid Integer for Set #1 Rep Amount (no decimals)."},
                {"Transition", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "km", "", "", "m", "-1", "ft", "", "", "", "Great", "2 (Light)", "", "", "", "", "", "", "", "", "*Elevation Loss cannot be less than 0.00."},
                {"Transition", "advanced", randomDate(), "", "", "", "no", "", "", "", "", "", "", "m", "", "", "m", "", "ft", "", "", "", "Normal", "2 (Light)", "", "0,1", "", "", "", "", "", "", "*Please enter a valid Integer for Maximum Wattage (no decimals)."}
        };
    }

    @Test(dataProvider = "Bik and Walk and Transition")
    public void createBikeOrWalkOrTransition(String typeWorkout, String activityType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                             String planedDistType, String planedDuration, String paceType, String reps, String distance, String distType, String duration, String elGain,
                                             String elGainType, String elLoss, String elLossType, String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort,
                                             String powAvg, String powMax, String cadAvg, String cadMax, String minHR, String avgHR, String maxHR, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(typeWorkout);
        addWorkoutPage.createBikeOrWalkOrTransition(activityType, Workout.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .showDistance(showDistance)
                .plannedDistance(plannedDistance)
                .planedDistType(planedDistType)
                .planedDuration(planedDuration)
                .distance(distance)
                .distType(distType)
                .duration(duration)
                .reps(reps)
                .paceType(paceType)
                .elGain(elGain)
                .elGainType(elGainType)
                .elLoss(elLoss)
                .elLossType(elLossType)
                .markAsRace(markAsRace)
                .overallPlace(overallPlace)
                .ageGroupPlace(ageGroupPlace)
                .feel(feel)
                .effort(effort)
                .powAvg(powAvg)
                .powMax(powMax)
                .cadAvg(cadAvg)
                .cadMax(cadMax)
                .minHR(minHR)
                .avgHR(avgHR)
                .maxHR(maxHR)
                .kCal(kCal)
                .build());
        addWorkoutPage.assertNameOrErrorWorkout(typeWorkout, name, error);
    }*/
}
