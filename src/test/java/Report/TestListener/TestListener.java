package Report.TestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public static int passedTests = 0;
    public static int failedTests = 0;
    public static int skippedTests = 0;

    @Override
    public void onTestStart(ITestResult res) {
        System.out.println("Started test case is "+ res.getName());
    }

    @Override
    public void onStart(ITestContext res) {
        System.out.println("TEST CASE "+ res.getName()+" IS STARTED ");
    }

    @Override
    public void onFinish(ITestContext res) {
        System.out.println("TEST CASE "+ res.getName()+" IS FINISHED ");
    }

    @Override
    public void onTestSuccess(ITestResult res) {
        System.out.println("Test case PASSED is " + res.getName());
        passedTests++;
    }
    // Run when the test case fails
    @Override
    public void onTestFailure(ITestResult res) {
        System.out.println("Test case FAILED is " + res.getName());
        failedTests++;
    }
    // Run when test case pass with some failures
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult res) {
        System.out.println("Test case passed with FAILURE is " + res.getName());
    }
    // Run when the test case is skipped
    @Override
    public void onTestSkipped(ITestResult res) {
        System.out.println("Test case SKIPPED is :" + res.getName());
        skippedTests++;
    }
}
