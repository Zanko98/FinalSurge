package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddWorkoutPage extends WorkoutBasePage{

    public void createRunOrCrossTraining(String type, Workout workout) {
        editBaseFields(workout);
        if (workout.getShowDistance().equals("yes")) editPlanedDistance(workout);
        editWorkout(type, workout);
        if (workout.getMarkAsRace().equals("yes")) editRace(workout);
        editFeltAndEffort(workout);
        editHR(workout);
        editKCal(workout);
        clickSaveButton();
    }

    public void createBikeOrWalkOrTransition(String type, Workout workout) {
        editBaseFields(workout);
        if (workout.getShowDistance().equals("yes")) editPlanedDistance(workout);
        editWorkout(type, workout);
        editPower(workout);
        if (workout.getMarkAsRace().equals("yes") && $(By.xpath("//a[@data-code='trans']/i[@class]")).getAttribute("class").equals("icon-chevron-left"))
        editFeltAndEffort(workout);
        editElevation(workout);
        editHR(workout);
        editKCal(workout);
        clickSaveButton();
    }

    public void createSwim(String type, Workout swim) {
        editBaseFields(swim);
        if (swim.getShowDistance().equals("yes")) editPlanedDistance(swim);
        editWorkout(type, swim);
        if (swim.getMarkAsRace().equals("yes")) editRace(swim);
        editFeltAndEffort(swim);
        editKCal(swim);
        clickSaveButton();
    }

    public void createRestDayOrRecovery(Workout workout) { //Recovery
        editBaseFields(workout);
        clickSaveButton();
    }

    public void createStrengthTraining(Workout strengthTraining) {
        editBaseFields(strengthTraining);
        $("#DurationNoInt").sendKeys(strengthTraining.getDuration());
        editFeltAndEffort(strengthTraining);
        clickSaveButton();
    }

    public void assertNameAndErrorWorkout(String TypeWorkout, String name, String error){
        if (error.isEmpty()) {
            $(By.xpath("//h4[text()='Workout Details']")).shouldBe(Condition.visible);
            assertEquals($(".activityTypeName").getText(), TypeWorkout);
            assertEquals($("div[style~='clear:']").getText(), name);
        } else { System.out.println($("div.alert").getText()); // потом удалить
            assertTrue($("div.alert").getText().contains(error));
        }

    }

}
