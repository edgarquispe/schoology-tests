package org.example;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class BrowserFactory {

    private BrowserFactory() {
    }

    private static final Map<String, Supplier<AbstractBrowser>> BROWSERS = new HashMap<>();
    static {
        BROWSERS.put("chrome", Chrome::new);
        BROWSERS.put("firefox", Firefox::new);
        BROWSERS.put("headless", Headless::new);
    }

    public static WebDriver getBrowser(final String browser) {
            return BROWSERS.getOrDefault(browser, Chrome::new).get().init();
    }
}
