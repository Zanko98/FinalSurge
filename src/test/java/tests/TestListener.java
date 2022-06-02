package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.printf("==================================== STARTING TEST %s ========================================%n", iTestResult.getName());
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.printf("====================================FINISHED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.printf("==================================== FAILED TEST %s Duration: %ss ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));
        screenshot("screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.printf("==================================== SKIPPING TEST %s ========================================%n", iTestResult.getName());
        screenshot("screenshot");
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
