package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;
	
	public static void startReport() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();

			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getTestsReportPath());
			try {
				spark.loadJSONConfig(new File(FrameworkConstants.getJsonFilePath()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			spark.viewConfigurer().viewOrder()
					.as(new ViewName[] { ViewName.TEST, ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.AUTHOR })
					.apply();
			extent.attachReporter(spark);
		}
	}

	public static void createTest(String testcaseName) {
		ExtentManager.setExtentTest(extent.createTest(testcaseName));
	}

	public static void endReport() {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.unloadExtentTest();

			try {
				Desktop.getDesktop().browse(new File(FrameworkConstants.getTestsReportPath()).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}