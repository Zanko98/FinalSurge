package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.debug("==================================== STARTING TEST %s ========================================%n",
                iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.debug("====================================FINISHED TEST %s Duration: %ss ========================================%n",
                iTestResult.getName(), getExecutionTime(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.debug("==================================== FAILED TEST %s Duration: %ss ========================================%n",
                iTestResult.getName(), getExecutionTime(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.debug("==================================== SKIPPING TEST %s ========================================%n",
                iTestResult.getName());
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
