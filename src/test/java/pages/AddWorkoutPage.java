package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddWorkoutPage extends WorkoutBasePage {

    @Step("adding workouts")
    public void createRunOrSwimOrCross(String type, Workout workout) {
        editBaseFields(workout);
        editPlanedDistance(workout);
        editWorkout(type, workout);
        editRace(workout);
        editFeltAndEffort(workout);
        if (iconLeft("swim")) editHR(workout);
        editKCal(workout);
        clickSaveButton();
    }

    @Step("adding workouts")
    public void createBikeOrWalkOrTransition(String type, Workout workout) {
        editBaseFields(workout);
        editPlanedDistance(workout);
        editWorkout(type, workout);
        editPower(workout);
        if (iconLeft("trans")) editRace(workout);
        editFeltAndEffort(workout);
        editElevation(workout);
        editHR(workout);
        editKCal(workout);
        clickSaveButton();
    }

    @Step("adding workouts")
    public void createRestDayOrRecoveryOrStrengthOrOther(Workout workout) {
        editBaseFields(workout);
        if (!iconLeft("strength-t")) {
            $("#DurationNoInt").sendKeys(workout.getDuration());
            editFeltAndEffort(workout);
        }
        clickSaveButton();
    }

    @Step("Reconciliation of errors {error} or the name {name} of a saved workout")
    public void assertNameOrErrorWorkout(String typeWorkout, String name, String error) {
        if (error.isEmpty()) {
            $(By.xpath("//h4[text()='Workout Details']")).shouldBe(Condition.visible);
            assertEquals($(".activityTypeName").getText(), typeWorkout, "The activity type does not match");
            assertEquals($("div[style~='clear:']").getText(), name, "The training name does not match");
        } else {
            assertTrue($("div.alert").getText().contains(error), "Incorrect displayed error");
        }
    }
}
