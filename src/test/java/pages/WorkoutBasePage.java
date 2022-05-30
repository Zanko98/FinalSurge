package pages;

import com.codeborne.selenide.Condition;
import dto.Workout;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkoutBasePage extends BasePage {

    public void openPage() {
        open("WorkoutAdd.cshtml");
        $(By.partialLinkText("Customize this page")).shouldBe(Condition.visible);
    }

    public void selectActivityType(String name) {
        $(By.partialLinkText(name)).click();
    }

    public void editBaseFields(Workout run) {
        $("#WorkoutDate").clear();
        $("#WorkoutDate").sendKeys(run.getData());
        if ($(By.xpath("//a[@data-code='rest']/i[@class]")).getAttribute("class").equals("icon-chevron-left"))
            $("#WorkoutTime").sendKeys(run.getTimeOfDay());
        $("#Name").sendKeys(run.getName());
        $("#Desc").sendKeys(run.getDescription());
    }

    public void editPlanedDistance(Workout run) {
        $("#PlannedWorkout").click();
        $("#PDistance").sendKeys(run.getPlannedDistance());
        $("#PDistType").selectOption(run.getPlanedDistType());
        $("#PDuration").sendKeys(run.getPlanedDuration());
    }

    public void editRace(Workout run) {
        $("#IsRace").click();
        $("#OverallPlace").sendKeys(run.getOverallPlace());
        $("#AgeGroupPlace").sendKeys(run.getAgeGroupPlace());
    }

    public void editFeltAndEffort(Workout run) {
        $(By.xpath(String.format("//label[normalize-space()='%s']", run.getFeel()))).click();
        $("#PerEffort").selectOption(run.getEffort());
    }

    public void editHR(Workout run) {
        $("#MinHR").sendKeys(run.getMinHR());
        $("#AvgHR").sendKeys(run.getAvgHR());
        $("#MaxHR").sendKeys(run.getMaxHR());
    }

    public void editKCal(Workout run) {
        $("#kCal").sendKeys(run.getKCal());
    }

    public void editWorkout(String type, Workout run) {
        if (type.equals("advanced")) {
            $("#tIntervals").click();
            $("#SetReps1").sendKeys(run.getReps());
            $("#SetDist1").sendKeys(run.getDistance());
            $("#SetTime1").sendKeys(run.getDuration());
            $("#SetDistType1").selectOption(run.getDistType());
        } else {
            $("#tBasic").click();
            $("#Distance").sendKeys(run.getDistance());
            $("#DistType").selectOption(run.getDistType());
            $("#Duration").sendKeys(run.getDuration());
            $("#PaceType").selectOption(run.getPaceType());
        }
    }

    public void editPower(Workout run) { //для Transition / Bike /Walk
        $("#PowAvg").sendKeys(run.getPowAvg());
        $("#PowMax").sendKeys(run.getPowMax());
        $("#CadAvg").sendKeys(run.getCadAvg());
        $("#CadMax").sendKeys(run.getCadMax());
    }

    public void editElevation(Workout run) {// для Bike /Walk
        $("#EGain").sendKeys(run.getElGain());
        $("#EGainDistType").selectOption(run.getElGainType());
        $("#ELoss").sendKeys(run.getElLoss());
        $("#ELossDistType").selectOption(run.getElLossType());
    }

    public void clickSaveButton() {
        $("#saveButton").click();
    }

    public void getErrorMessage() {

    }
}
