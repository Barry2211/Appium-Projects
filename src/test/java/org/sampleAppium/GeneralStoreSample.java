package org.sampleAppium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class GeneralStoreSample {

	public static void main(String[] args) throws InterruptedException {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File(
								"C:\\Users\\BARRY\\AppData\\Roaming\\npm\\"
								+ "node_modules\\appium\\build\\lib\\main.js"
								)
						)
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("sdk_gphone64_x86_64");
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setApp("D:\\Downloads\\General-Store.apk");
		
		AndroidDriver driver = new AndroidDriver(service.getUrl(), options);
		
		TimeUnit.SECONDS.sleep(10);
		driver.quit();
		service.stop();
		
	}

}
