package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {}
	
	private static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static Media attachScreenshot() {
		return MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build();
	}
	
	public static Media attachSnap() {
		return MediaEntityBuilder.createScreenCaptureFromPath(takeSnap()).build();
	}

	public static String takeSnap() {
		String destPath;

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat SDF = new SimpleDateFormat("dd_MM_YYYY_HHmmss");
		String sDate = SDF.format(date);

		destPath = System.getProperty("user.dir") + "/Screenshots/" + sDate + ".png";
		File destFile = new File(destPath);

		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath;
	}
}