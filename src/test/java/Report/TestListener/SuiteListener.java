package Report.TestListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        // Код, который нужно выполнить перед запуском suite (необязательно)
        System.out.println("Suite is started " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        // Код для отправки отчета после завершения suite
        System.out.println("Suite is finished " + suite.getName());

        int passedTests = TestListener.passedTests;
        int failedTests = TestListener.failedTests;
        int skippedTests = TestListener.skippedTests;
        int totalTests = passedTests + failedTests + skippedTests;
    }
}
