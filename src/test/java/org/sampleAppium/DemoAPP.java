package org.sampleAppium;

import java.util.concurrent.TimeUnit;

import org.base.AppiumKeys;
import org.base.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DemoAPP {
	
	public static void main(String[] args) throws InterruptedException {
		AppiumDriverLocalService service = AppiumUtils.getService();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(AppiumKeys.Pixel9.getInfo());
		options.setPlatformName(AppiumKeys.Android.getInfo());
		options.setAutomationName(AppiumKeys.UiAutomator2.getInfo());
		options.setApp(AppiumKeys.DemoApiApp.getInfo());
		
		AndroidDriver driver = new AndroidDriver(service.getUrl(), options);
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile:longClickGesture",ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"duration", 3000
				));
		
		TimeUnit.SECONDS.sleep(10);
		driver.quit();
		service.stop();
		
	}
}
