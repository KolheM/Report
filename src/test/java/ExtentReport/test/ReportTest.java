package ExtentReport.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ReportTest extends Report {

	@Test
	public void testCase_1() {
		Assert.assertTrue(true);
		logger.info("This is test case 1.");
	}

	@Test
	public void testCase_2() {
		Assert.assertTrue(true);
		logger.info("This is test case 2.");
		logger.pass("This is test case 2.1.");
	}

	@Test(groups = { "regression" })
	public void testCase_3() {
		Assert.assertTrue(true);
		logger.info("This is test case 3.");
		logger.pass("This is test case 3.1.");
	}

	@Test
	public void testCase_4() {
		// Assert.assertTrue(false);
		logger.info("This is test case 4.");
		Markup m = MarkupHelper.createCodeBlock("Pass: Test Data testCase_4");
		Markup m1 = MarkupHelper.createCodeBlock("Fail: Test Data testCase_4");
		logger.info(m);
		logger.info(m1);
	}

	@Test(groups = { "smoke" })
	public void testCase_5() {
		Assert.assertTrue(true);
		logger.info("This is test case 5.");
		logger.pass("This is test case 5.1.");
	}
}
