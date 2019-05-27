package ExtentReport.otherTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ExtentReport.test.Report;

public class HomePage extends Report {

	@Test
	public void testCaseHomePage_1() {
		logger.info("This is test case 1.");
	}

	@Test(groups = { "smoke" })
	public void testCaseHomePage_2() {
		logger.info("This is test case 2.");
	}

	@Test(groups = { "smoke" })
	public void testCaseHomePage_3() {
		logger.info("This is test case 3.");
		logger.log(Status.INFO,"Usage: BOLD TEXT");
	}

	@Test(groups = { "smoke","regression" })
	public void testCaseHomePage_4() {
		logger.info("This is test case 4.");
	}

	@Test
	public void testCaseHomePage_5() {
		logger.info("This is test case 5.");
	}
}
