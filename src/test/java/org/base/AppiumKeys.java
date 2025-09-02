package org.base;

public enum AppiumKeys {

	Pixel9("sdk_gphone64_x86_64"),
	Android("Android"),
	Iphone("iOS"),
	UiAutomator2("UiAutomator2"),
	GeneralStoreApp("D:\\Downloads\\APKs\\General-Store.apk"),
	DemoApiApp("D:\\Downloads\\APKs\\ApiDemos-debug.apk")
	;
	
	private String info;
	
	private AppiumKeys(String info) {
		this.info=info;
	}
	
	public String getInfo() {
		return info;
	}
}
