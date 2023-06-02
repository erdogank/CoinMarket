package com.coinmarket.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Driver {
    static String browser;

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver()  {
        if (driver == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            switch (browser) {
                case "remote-chrome":

                    try {
//
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless=new");
                        driver = new RemoteWebDriver(new URL("http://52.90.125.198:4444"),chromeOptions);
                        driver.manage().window().setSize(new Dimension(1920, 1080));
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case "chrome":

                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "chrome-headless":

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");

                    driver = new ChromeDriver(options);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    break;
                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":

                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }

                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }

                    driver = new EdgeDriver();
                    break;


            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
