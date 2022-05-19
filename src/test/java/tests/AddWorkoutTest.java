package tests;

import dto.Workout.Run;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    @DataProvider(name = "хз createRunningWorkout")
    public Object[][] inputForEditUserProfile() {
        return new Object[][]{
                {"basic", "21/5/2022", "06:00 AM", "bla", "blab","yes", "10", "mi", "15:15", "15", "km", "15:18", "1","22","15:18","mi", "kph", "yes", "88", "12", "Good", "2 (Light)", "1", "1", "1", "111"},
        };
    }

    @Test(dataProvider = "хз createRunningWorkout")
    public void createRunningWorkout(String runType, String data,String  timeOfDay, String name, String  description, String showDistance, String plannedDistance,
                                     String  planedDistType, String  planedDuration, String  distance, String distType,String  duration, String  reps, String advDistance,
                                     String  advDistType, String AdvDuration, String  paceType, String  markAsRace, String  overallPlace, String ageGroupPlace,
                                     String  feel, String  effort, String  minHR,String  avgHR, String  maxHR, String  kCal) {

        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType("Run");
        addWorkoutPage.createWorkout(runType, Run.builder()
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
        titlePage.logOut();
    }
}
