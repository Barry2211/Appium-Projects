package org.base;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {

	public static AppiumDriverLocalService getService() {
		return new AppiumServiceBuilder()
				.withAppiumJS(
						new File(
								"C:\\Users\\BARRY\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
								)
						)
				.withIPAddress("127.0.0.1").usingPort(4723).build();
	}
}
