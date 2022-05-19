package pages;

import com.codeborne.selenide.Condition;
import dto.Workout.Run;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddWorkoutPage extends BasePage{

    public void openPage(){
        open("WorkoutAdd.cshtml");
        $(By.partialLinkText("Customize this page")).shouldBe(Condition.visible);
    }

    public void selectActivityType(String name){
        $(By.partialLinkText(name)).click();
    }

    public void createWorkout(String type, Run run){
        $("#WorkoutDate").clear();
        $("#WorkoutDate").sendKeys(run.getData());
        $("#WorkoutTime").sendKeys(run.getTimeOfDay());
        $("#Name").sendKeys(run.getName());
        $("#Desc").sendKeys(run.getDescription());
        if (run.getShowDistance().equals("yes")){
            $("#PlannedWorkout").click();
            $("#PDistance").sendKeys(run.getPlannedDistance());
            $("#PDistType").selectOption(run.getPlanedDistType());
            $("#PDuration").sendKeys(run.getPlanedDuration());
        }
        if (type.equals("advanced")){
            $("#tIntervals").click();
            $("#SetReps1").sendKeys(run.getReps());
            $("#SetDist1").sendKeys(run.getAdvDistance());
            $("#SetTime1").sendKeys(run.getAdvDuration());
            $("#SetDistType1").selectOption(run.getAdvDistType());
        }else{
            $("#tBasic").click();
            $("#Distance").sendKeys(run.getDistance());
            $("#DistType").selectOption(run.getDistType());
            $("#Duration").sendKeys(run.getDuration());
            //$("#Pace").sendKeys(run.getPace());
            $("#PaceType").selectOption(run.getPaceType());
        }
        if (run.getMarkAsRace().equals("yes")) {
            $("#IsRace").click();
            $("#OverallPlace").sendKeys(run.getOverallPlace());
            $("#AgeGroupPlace").sendKeys(run.getAgeGroupPlace());
        }
        $(By.xpath(String.format("//label[normalize-space()='%s']", run.getFeel()))).click();
        $("#PerEffort").selectOption(run.getEffort());
        $("#MinHR").sendKeys(run.getMinHR());
        $("#AvgHR").sendKeys(run.getAvgHR());
        $("#MaxHR").sendKeys(run.getMaxHR());
        $("#kCal").sendKeys(run.getKCal());
        $("#saveButton").click();
    }
}
