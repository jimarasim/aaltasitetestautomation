package io.aalta.Common;

import org.openqa.selenium.Platform;

public enum BrowserEnum {
    FIREFOX("firefox","",Platform.MAC),
    SAFARI("safari","",Platform.MAC),
    CHROME("chrome","",Platform.MAC),
    BROWSERSTACK_CHROME_MAC("chrome","",Platform.MAC),
    BROWSERSTACK_FIREFOX_MAC("firefox","",Platform.MAC),
    BROWSERSTACK_SAFARI_MAC("safari","",Platform.MAC),
    BROWSERSTACK_CHROME_WINDOWS("chrome","",Platform.WINDOWS),
    BROWSERSTACK_FIREFOX_WINDOWS("firefox","",Platform.WINDOWS),
    BROWSERSTACK_SAFARI_WINDOWS("safari","",Platform.WINDOWS),
    BROWSERSTACK_SAFARI_IPHONE("iPhone", "11", Platform.IOS);

    public final String browserName;
    public final String version;
    public final Platform platform;

    BrowserEnum(final String browserName, final String version, final Platform platform) {
        this.browserName = browserName;
        this.version = version;
        this.platform = platform;
    }


}
