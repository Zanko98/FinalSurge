package tests;


import dto.Workout;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    @DataProvider(name = "Run")
    public Object[][] inputForCreateRun() {
        return new Object[][]{
                {"Run","basic","31/05/2022","6:00 AM","","!@#$%^&*()_+","yes","10","km","0:01","min/mi","","0","km","1:01","yes","","99999","Good","2 (Light)","300","0","","1",""},
                {"Run","basic","31/05/2022","","","","yes","!@#$%^&*()_+","m","","min/km","","","mi","","no","","","Great","3 (Light)","","","","","*Please enter a valid Planned Distance."},
                {"Run","basic","31/05/2022","","","","no","","","","mph","","","yd","","yes","-1","","Great","2 (Light)","","","","","*Overall Place cannot be less than 1."},
                {"Run","basic","31/05/2022","","","","no","","","","kph","","","km","","yes","100001","","Great","2 (Light)","","","","","*Overall Place cannot be greater than 100000."},
                {"Run","advanced","31/05/2022","","","","no","","","","","-1","","yd","","no","","","Normal","2 (Light)","","","","","*Set #1 Rep Amount cannot be less than 1."},
                {"Run","advanced","31/05/2022","","","","no","","","","","","","m","","no","","","Normal","Select...","","","","-1","*Calories Burned cannot be less than 0."},
                {"Run","advanced","31/05/2022","","","","no","","","","","","","m","","no","","","Poor","2 (Light)","","","301","","*Maximum Heartrate cannot be greater than 300."},
                {"Run","advanced","31/05/2022","","","","no","","","","","","!@#$%^&*()_+","m","","no","","","Poor","3 (Light)","","","","","*You must have at least one Set or Rep Distance and/or Duration for Set #1."},
                {"Run","advanced","31/05/2022","","","","no","","","","","","","mi","","yes","","0,1","Terrible","3 (Light)","","","","","*Please enter a valid Integer for Age Group Place (no decimals)."}
        };
    }

    @Test(dataProvider = "Run")
    public void createRun(String TypeWorkout, String activityType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                         String planedDistType, String planedDuration, String paceType, String reps, String distance, String distType, String duration,
                                         String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort, String minHR, String avgHR,
                                         String maxHR, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
        addWorkoutPage.createRun(activityType, Workout.builder()
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
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }

    @DataProvider(name = "CrossTraining")
    public Object[][] inputForCrossTraining() {
        return new Object[][]{
                {"Cross Training", "31/05/2022", "000", "","" , "yes", "0,1", "yd", "55:55:59", "min/1500m",  "", "yd", "55:55:59", "yes", "99999", "", "Poor", "Select...", "", "1", "299","", ""},
                {"Cross Training", "31/05/2022", "", "", "", "no", "", "", "", "min/100m",  "", "km", "", "no", "", "", "Good", "Select...", "", "301", "", "", "*Average Heartrate cannot be greater than 300."},
                {"Cross Training", "31/05/2022", "", "", "", "no", "", "", "", "min/100y",  "", "mi", "", "yes", "", "-1", "Normal", "Select...", "", "", "", "", "*Age Group Place cannot be less than 1."},
                {"Cross Training", "31/05/2022", "", "", "", "yes", "", "m", "55:55:60", "mph", "", "yd", "", "no", "", "", "Terrible", "Select...", "", "", "", "", "*You must have at least one Set or Rep Distance and/or Duration for Set #1."},
                {"Cross Training", "31/05/2022", "", "", "", "no", "", "", "", "min/100y", "-1", "km", "", "no", "", "", "Normal", "2 (Light)", "", "", "", "", "*The Distance cannot be less than 0.00."},
                {"Cross Training", "31/05/2022", "", "", "", "no", "", "", "", "min/1500m", "", "km", "", "no", "", "", "Good", "Select...", "0,1", "", "", "", "*Please enter a valid Integer for Minimum Heartrate (no decimals)."},
                {"Cross Training", "31/05/2022", "", "", "", "no", "", "", "", "min/100m", "", "km", "", "no", "", "", "Great", "2 (Light)", "", "-1", "", "", "*Average Heartrate cannot be less than 0."}
        };
    }

    @Test(dataProvider = "CrossTraining")
    public void createCrossTraining(String TypeWorkout, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                         String planedDistType, String planedDuration, String paceType, String distance, String distType, String duration,
                                         String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort, String minHR, String avgHR,
                                         String maxHR, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
        addWorkoutPage.createCrossTraining(Workout.builder()
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
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }

    @DataProvider(name = "Swim")
    public Object[][] inputForCreateSwim() {
        return new Object[][]{
                {"Swim", "basic", "28/06/2022", "8:00 PM", "", "", "yes", "", "m", "0", "min/1500m", "", "", "mi", "000000", "yes", "100000", "", "Normal", "3 (Light)", "0", ""},
                {"Swim", "basic", "28/06/2022", "", "", "", "yes", "", "m", "9999999", "min/100m", "", "", "km", "", "no", "", "", "Poor", "3 (Light)", "", "*Please enter a valid Planned Duration in the format hours:minutes:seconds (hh:mm:ss)."},
                {"Swim", "basic", "28/06/2022", "", "", "", "no", "", "", "", "min/100y", "", "", "mi", "", "yes", "", "100001", "Good", "2 (Light)", "", "*Age Group Place cannot be greater than 100000."},
                {"Swim", "basic", "28/06/2022", "", "", "", "no", "", "", "", "mph", "", "!@#$%^&*()_+", "mi", "", "no", "", "", "Good", "3 (Light)", "", "*Please enter a valid Distance."},
                {"Swim", "advanced", "28/06/2022", "", "", "", "no", "", "", "", "", "", "", "mi", "", "no", "", "", "Good", "2 (Light)", "0,1", "*Please enter a valid Integer for Calories Burned (no decimals)."},
                {"Swim", "advanced", "28/06/2022", "", "", "", "yes", "-1", "km", "", "", "", "", "yd", "", "no", "", "", "Terrible", "Select...", "", "*The Planned Distance cannot be less than 0.00."},
                {"Swim", "advanced", "28/06/2022", "", "", "", "yes", "", "mi", "1", "", "300", "", "km", "", "no", "", "", "Good", "Select...", "", "*Set #1 Rep Amount cannot be greater than 299."},
                {"Swim", "advanced", "28/06/2022", "", "", "", "no", "", "", "", "", "", "", "m", "55:55:61", "no", "", "", "Great", "Select...", "", "*Please enter a valid Set #1 Duration in the format hours:minutes:seconds (hh:mm:ss)."}
        };
    }

    @Test(dataProvider = "Swim")
    public void createSwim(String TypeWorkout, String activityType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                           String planedDistType, String planedDuration, String paceType, String reps, String distance, String distType, String duration,
                           String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
        addWorkoutPage.createSwim(activityType, Workout.builder()
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
                .kCal(kCal)//8
                .build());
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }

    @DataProvider(name = "RestDay and Recovery and Other")
    public Object[][] inputForCreateRestDayAndRecovery() {
        return new Object[][]{
                {"Rest Day", "25/5/2022", "", "", "", ""},
                {"Rest Day", "25/5/2022", "", test100+test100+1, "", "*The Workout Name cannot be more than 200 characters."},
                {"Recovery/Rehab", "25/5/2022", "", test100+test100, "*", ""},
                {"Recovery/Rehab", "", "", "", "", "*Please enter a value for Workout Date."}
        };
    }

    @Test(dataProvider = "RestDay and Recovery and Other")
    public void createRestDayAndRecovery(String TypeWorkout, String data,String timeOfDay, String name, String description, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
        addWorkoutPage.createRestDayOrRecovery(Workout.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .build());
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }

   @DataProvider(name = "Bik and Walk and Transition")
    public Object[][] inputForCreateBikeOrWalkOrTransition() {
        return new Object[][]{
                {"Bike","advanced","21/05/2022","","","","yes","0","m","","","299","0,1","m","000000","999999999","ft","0","m","yes","","1","Great","2 (Light)","0","5000","","9999","299","","1","",""},
                {"Bike","advanced","21/05/2022","","","","no","","","","","","","km","","","ft","","m","no","","","Great","3 (Light)","","0","0,1","","","","","","*Please enter a valid Integer for Average Cadence (no decimals)."},
                {"Bike","advanced","21/05/2022","","","","no","","","","","","","mi","","","ft","~!@#$%^&*()_+","m","no","","","Normal","Select...","","","","","","","","","*Please enter a valid Elevation Loss."},
                {"Bike","advanced","21/05/2022","","","","no","","","","","","","yd","","","ft","","ft","no","","","Normal","Select...","-1","","","","","","","","*Average Wattage cannot be less than 0."},
                {"Bike","advanced","21/05/2022","","","","no","","","","","","0","yd","","","ft","","ft","no","","100000","Normal","Select...","","","","","","","","","*You must have at least one Set or Rep Distance and/or Duration for Set #1."},
                {"Bike","advanced","21/05/2022","","","","no","","","","","","","yd","1:01","","ft","","ft","yes","0,1","","Normal","Select...","","","","","","","","","*Please enter a valid Integer for Overall Place (no decimals)."},
                {"Bike","basic","21/05/2022","","","","no","","","","min/1500m","","999999999","km","","","m","","ft","no","","","Poor","3 (Light)","","","","","","","0,1","","*Please enter a valid Integer for Maximum Heartrate (no decimals)."},
                {"Bike","basic","21/05/2022","","","","no","","","","min/100y","","","mi","","","m","","ft","no","","","Terrible","3 (Light)","","","-1","","","","","","*Average Cadence cannot be less than 0."},
                {"Walk", "advanced", "21/05/2022", "", "", "", "yes", "999999999", "yd", "", "", "1", "99999", "m", "55:55:59", "0,1", "m","","ft","yes", "1", "", "Poor", "Select...", "5000", "499", "0", "", "0", "299", "300", "",""},
                {"Walk", "advanced", "21/05/2022", "", "", "", "no", "", "", "", "", "", "", "m", "", "", "m", "", "ft", "no", "", "", "Good", "2 (Light)", "", "", "", "0,1", "", "", "", "", "*Please enter a valid Integer for Maximum Cadence (no decimals)."},
                {"Walk", "advanced", "21/05/2022", "", "", "", "no", "", "", "", "", "", "", "km", "", "", "ft", "", "m", "no", "", "", "Terrible", "2 (Light)", "5001", "", "", "", "", "", "", "", "*Average Wattage cannot be greater than 5000."},
                {"Walk", "advanced", "21/05/2022", "", "", "", "no", "", "", "", "", "0", "", "km", "", "", "ft", "", "m", "no", "", "", "Terrible", "3 (Light)", "", "", "", "", "", "", "", "", "*Set #1 Rep Amount cannot be less than 1."},
                {"Walk", "advanced", "21/05/2022", "", "", "", "no", "", "", "", "", "", "", "mi", "!@#$%^&*()_+", "", "ft", "", "m", "no", "", "", "Good", "3 (Light)", "", "-1", "", "", "", "", "", "", "*Maximum Wattage cannot be less than 0."},
                {"Walk", "basic", "21/05/2022", "", "", "", "no", "", "", "", "kph", "", "", "yd", "", "", "ft", "", "ft", "no", "", "", "Great", "2 (Light)", "", "", "", "", "", "0,1", "", "", "*Please enter a valid Integer for Average Heartrate (no decimals)."},
                {"Walk", "basic", "21/05/2022", "", "", "", "no", "", "", "", "min/1500m", "", "", "km", "", "~!@#$%^&*()_+", "ft", "", "m", "no", "", "", "Great", "2 (Light)","","","","","","","","","*Please enter a valid Elevation Gain."},
                {"Walk", "basic", "21/05/2022", "", "", "", "no", "", "", "", "min/100y", "", "", "yd", "", "-1", "m", "", "ft", "no", "", "", "Normal", "2 (Light)", "", "", "", "", "", "", "", "", "*Elevation Gain cannot be less than 0.00."},
                {"Transition", "basic", "30/05/2022", "", "", "", "yes", "", "mi", "000000", "min/km", "", "0,1", "m", "", "", "m", "999999999", "ft", "", "", "", "Poor", "Select...", "499", "", "9999", "0", "1", "300", "0", "", ""},
                {"Transition", "basic", "30/05/2022", "", "", "", "no", "", "", "", "mph", "", "", "km", "", "", "ft", "", "m", "", "", "", "Good", "2 (Light)", "", "5001", "", "", "", "", "", "", "*Maximum Wattage cannot be greater than 5000."},
                {"Transition", "basic", "30/05/2022", "", "", "", "no", "", "", "", "kph", "", "", "mi", "", "0", "ft", "", "m", "", "", "", "Terrible", "2 (Light)", "", "", "", "", "", "", "-1", "", "*Maximum Heartrate cannot be less than 0."},
                {"Transition", "basic", "30/05/2022", "", "", "", "no", "", "", "", "min/100y", "", "", "km", "!@#$%^&*()_+", "", "ft", "", "ft", "", "", "", "Good", "3 (Light)", "", "", "", "-1", "", "", "", "", "*Maximum Cadence cannot be less than 0."},
                {"Transition", "advanced", "30/05/2022", "", "", "", "no", "", "", "", "", "", "", "mi", "", "", "m", "", "ft", "", "", "", "Great", "2 (Light)", "0,1", "", "", "", "", "", "", "", "*Please enter a valid Integer for Average Wattage (no decimals)."},
                {"Transition", "advanced", "30/05/2022", "", "", "", "no", "", "", "", "", "0,1", "-1", "mi", "", "", "ft", "", "m", "", "", "", "Great", "3 (Light)", "", "", "", "", "", "", "", "", "*Please enter a valid Integer for Set #1 Rep Amount (no decimals)."},
                {"Transition", "advanced", "30/05/2022", "", "", "", "no", "", "", "", "", "", "", "km", "", "", "m", "-1", "ft", "", "", "", "Great", "2 (Light)", "", "", "", "", "", "", "", "", "*Elevation Loss cannot be less than 0.00."},
                {"Transition", "advanced", "30/05/2022", "", "", "", "no", "", "", "", "", "", "", "m", "", "", "m", "", "ft", "", "", "", "Normal", "2 (Light)", "", "0,1", "", "", "", "", "", "", "*Please enter a valid Integer for Maximum Wattage (no decimals)."}
        };
    }

    @Test(dataProvider = "Bik and Walk and Transition")
    public void createBikeOrWalkOrTransition(String TypeWorkout, String activityType, String data, String timeOfDay, String name, String description, String showDistance, String plannedDistance,
                                             String planedDistType, String planedDuration, String paceType, String reps, String distance, String distType, String duration, String elGain,
                                             String elGainType, String elLoss, String elLossType, String markAsRace, String overallPlace, String ageGroupPlace, String feel, String effort,
                                             String powAvg, String powMax, String cadAvg, String cadMax, String minHR, String avgHR, String maxHR, String kCal, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
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
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }

    @DataProvider(name = "StrengthTraining")
    public Object[][] inputForCreateStrengthTraining() {
        return new Object[][]{
                {"Strength Training", "28/06/2022", "", "!@#$%^&*()_+", "", "0","Terrible","Select...", ""},
                {"Strength Training", "03/06/2022", "","", "","55:55:60","Great","2 (Light)", "*Please enter a valid Duration in the format hours:minutes:seconds (hh:mm:ss)."},
        };
    }

    @Test(dataProvider = "StrengthTraining")
    public void createStrengthTraining(String TypeWorkout, String data, String timeOfDay, String name, String description, String duration, String feel, String effort, String error) {
        loginPage.login(EMAIL, PASSWORD);
        addWorkoutPage.openPage();
        addWorkoutPage.selectActivityType(TypeWorkout);
        addWorkoutPage.createStrengthTraining(Workout.builder()
                .data(data)
                .timeOfDay(timeOfDay)
                .name(name)
                .description(description)
                .duration(duration)
                .feel(feel)
                .effort(effort)
                .build());
        addWorkoutPage.assertNameAndErrorWorkout(TypeWorkout, name, error);
        titlePage.logOut();
    }
}
