package constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static String reportTimeStamp() {
		return "/Extent-Test-Output/Report -- " + new SimpleDateFormat("dd.MM.yyyy -- hh.mm.aa").format(new Date()).toString();
	}

	private static final int EXPLICIT_WAIT_DURATION = 10;

	private static final String PROJECT_PATH = System.getProperty("user.dir");
	private static final String RESOURCES_PATH = PROJECT_PATH + "/src/test/resources/";
	private static String REPORT_PATH = PROJECT_PATH +  reportTimeStamp() 	+ "/reports/Final_Report.html";
	
	private static final String JSON_CONFIG_PATH = RESOURCES_PATH + "jsons/extentConfig.json";
	private static final String CONFIG_FILE_PATH = RESOURCES_PATH + "config/config.properties";

	public static String getTestsReportPath() {
		return REPORT_PATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIG_FILE_PATH;
	}

	public static String getJsonFilePath() {
		return JSON_CONFIG_PATH;
	}
	
	public static int getExplicitWaitDuration() {
		return EXPLICIT_WAIT_DURATION;
	}
}