package ExtentReport.test;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest parentTest, logger;
	static String path = "C:\\Users\\admin\\testphoton-workspace\\test\\test-output\\ABC.html";

	/*
	 * static { htmlReporter = new ExtentHtmlReporter(path); extent = new
	 * ExtentReports(); extent.attachReporter(htmlReporter); }
	 */
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		if (htmlReporter == null) {
			htmlReporter = new ExtentHtmlReporter(path);

			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Test Title");

			extent = new ExtentReports();
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			extent.attachReporter(htmlReporter);
		}
		parentTest = extent.createTest(getClass().getSimpleName());

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		logger = parentTest.createNode(method.getName());
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		String[] groups = result.getMethod().getGroups();
		for (int i = 0; i < groups.length; i++) {
			logger.assignCategory(groups[i]);
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			logger.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extent.flush();
	}
}
