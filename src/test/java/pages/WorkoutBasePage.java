package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkoutBasePage extends BasePage {

    @Step("opening a workout page")
    public void openPage() {
        open("WorkoutAdd.cshtml");
        $(By.partialLinkText("Customize this page")).shouldBe(Condition.visible);
    }

    @Step("choosing a {name} workout")
    public void selectActivityType(String name) {
        $(By.partialLinkText(name)).click();
    }

    @Step("correction of the fields: data - {workout.getData()}, time - {}, Name, Description")
    public void editBaseFields(Workout workout) {
        $("#WorkoutDate").clear();
        $("#WorkoutDate").sendKeys(workout.getData());
        if (iconLeft("rest")) $("#WorkoutTime").sendKeys(workout.getTimeOfDay());
        $("#Name").sendKeys(workout.getName());
        $("#Desc").sendKeys(workout.getDescription());
    }

    @Step("correction of the fields: planned distance, planned duration")
    public void editPlanedDistance(Workout workout) {
        if (workout.getShowDistance().equals("yes")) {
            $("#PlannedWorkout").click();
            $("#PDistance").sendKeys(workout.getPlannedDistance());
            $("#PDistType").selectOption(workout.getPlanedDistType());
            $("#PDuration").sendKeys(workout.getPlanedDuration());
        }
    }

    @Step("correction of the fields: overall place, age group place")
    public void editRace(Workout workout) {
        if (workout.getMarkAsRace().equals("yes")) {
            $("#IsRace").click();
            $("#OverallPlace").sendKeys(workout.getOverallPlace());
            $("#AgeGroupPlace").sendKeys(workout.getAgeGroupPlace());
        }
    }

    @Step("the choice of feel and effort")
    public void editFeltAndEffort(Workout workout) {
        $(By.xpath(String.format("//label[normalize-space()='%s']", workout.getFeel()))).click();
        $("#PerEffort").selectOption(workout.getEffort());
    }

    @Step("correction of the fields: min, avg, max HR")
    public void editHR(Workout workout) {
        $("#MinHR").sendKeys(workout.getMinHR());
        $("#AvgHR").sendKeys(workout.getAvgHR());
        $("#MaxHR").sendKeys(workout.getMaxHR());
    }

    @Step("correction of the kCal")
    public void editKCal(Workout workout) {
        $("#kCal").sendKeys(workout.getKCal());
    }

    @Step("correction basic or advanced workout")
    public void editWorkout(String type, Workout workout) {
        if (iconLeft("cross-trai")) {
            if (type.equals("advanced")) {
                $("#tIntervals").click();
                $("#SetReps1").sendKeys(workout.getReps());
                $("#SetDist1").sendKeys(workout.getDistance());
                $("#SetTime1").sendKeys(workout.getDuration());
                $("#SetDistType1").selectOption(workout.getDistType());
            } else {
                $("#tBasic").click();
                $("#Distance").sendKeys(workout.getDistance());
                $("#DistType").selectOption(workout.getDistType());
                $("#Duration").sendKeys(workout.getDuration());
                $("#PaceType").selectOption(workout.getPaceType());
            }
        } else {
            $("#DistanceNoInt").sendKeys(workout.getDistance());
            $("#DistTypeNoInt").selectOption(workout.getDistType());
            $("#DurationNoInt").sendKeys(workout.getDuration());
            $("#PaceTypeNoInt").selectOption(workout.getPaceType());
        }
    }

    @Step("correction of the fields: avg, max power and avg, max cadence")
    public void editPower(Workout workout) {
        $("#PowAvg").sendKeys(workout.getPowAvg());
        $("#PowMax").sendKeys(workout.getPowMax());
        $("#CadAvg").sendKeys(workout.getCadAvg());
        $("#CadMax").sendKeys(workout.getCadMax());
    }

    @Step("correction of the elevation gain and loss")
    public void editElevation(Workout workout) {
        $("#EGain").sendKeys(workout.getElGain());
        $("#EGainDistType").selectOption(workout.getElGainType());
        $("#ELoss").sendKeys(workout.getElLoss());
        $("#ELossDistType").selectOption(workout.getElLossType());
    }

    @Step("click on the save button")
    public void clickSaveButton() {
        $("#saveButton").click();
    }

    public boolean iconLeft(String name) {
        return $(By.xpath(String.format("//a[@data-code='%s']/i[@class]", name))).getAttribute("class").equals("icon-chevron-left");
    }
}
