package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    @Getter
    private static Gson gson = new Gson();
    @Getter
    private static ExtentReports extentReports;//why
    @Getter
    @Setter
    private static ExtentTest testReporter;

    private static ExtentTest testClassReporter;


//    @BeforeSuite
//    public void beforeTestSuiteSetup() {
//
//        String reportName = String.format("test-report_%s.html", getDateTime());
//        ExtentSparkReporter spark = new ExtentSparkReporter(Properties.REPORT_LOCATION + reportName);
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(spark);
//    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassSetup(ITestContext context) {
        // Need to set this back to null as you can't get the name of the test class at this point
        testClassReporter = null;
    }


    @BeforeMethod(alwaysRun=true)
    public void beforeTestSetup(Method m) {

        if(testClassReporter == null) {
            String[] tmp = m.getDeclaringClass().getPackageName().split("[.]");
            String name = tmp[tmp.length -1] + "." + m.getDeclaringClass().getSimpleName();
            testClassReporter = extentReports.createTest(name);
        }

        testReporter = testClassReporter.createNode(m.getName());
        Test t = m.getAnnotation(Test.class);
        testReporter.assignCategory(t.groups());
    }

    @AfterMethod
    public void afterTestTearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE)
            testReporter.fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            testReporter.skip(result.getThrowable());
        else
            testReporter.pass("Test passed");

        extentReports.flush();
    }

    private String getDateTime() {
        String timeColonPattern = "d-MM-yyyy--HH-mm-ss";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalDateTime rightNow = LocalDateTime.now();
        return timeColonFormatter.format(rightNow);
    }

}
